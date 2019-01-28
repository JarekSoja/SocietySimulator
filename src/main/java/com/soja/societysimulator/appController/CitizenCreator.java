package com.soja.societysimulator.appController;

import com.soja.societysimulator.model.Citizen;
import com.soja.societysimulator.model.DoomsdayBook;
import com.soja.societysimulator.model.SocietyModel;
import com.vaadin.spring.annotation.SpringComponent;
import org.apache.commons.math3.random.RandomDataGenerator;
import org.apache.commons.math3.util.MathUtils;

import java.util.ArrayList;
import java.util.List;

@SpringComponent
public class CitizenCreator {

    private List<Citizen> citizensYearZero = new ArrayList<>();

    public void setYearZeroPopulation(DoomsdayBook doomsdayBook, SocietyModel societyModel) {
        initializeCitizens(societyModel);
        doomsdayBook.getCitizensByYear().put(0, citizensYearZero);
    }

    private void initializeCitizens(SocietyModel societyModel) {
        RandomDataGenerator randomDataGenerator = new RandomDataGenerator();
        for (int i = 0; i < societyModel.getPopulation(); i++) {
            double randomStartingCash = randomDataGenerator.nextGaussian(
                    societyModel.getMedianStartingCash(),
                    societyModel.getSigmaStartingCash());
            citizensYearZero.add(new Citizen(randomStartingCash));
        }
    }
}
