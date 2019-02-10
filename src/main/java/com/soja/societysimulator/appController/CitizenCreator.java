package com.soja.societysimulator.appController;

import com.soja.societysimulator.model.Citizen;
import com.soja.societysimulator.model.DoomsdayBook;
import com.soja.societysimulator.model.SocietyModel;
import com.vaadin.spring.annotation.SpringComponent;
import org.apache.commons.math3.random.RandomDataGenerator;

import java.util.ArrayList;
import java.util.List;

@SpringComponent
public class CitizenCreator {

    private List<Citizen> citizensYearZero = new ArrayList<>();
    RandomDataGenerator randomDataGenerator = new RandomDataGenerator();


    public void setYearZeroPopulation(DoomsdayBook doomsdayBook, SocietyModel societyModel) {
        initializeCitizens(societyModel);
        doomsdayBook.getCitizensByYear().put(0, citizensYearZero);
    }

    private void initializeCitizens(SocietyModel societyModel) {
        for (int i = 0; i < societyModel.getPopulation(); i++) {
            Citizen c = new Citizen();
            c.setCash(generateStartingCash(
                    societyModel.getMedianStartingCash(),
                    societyModel.getSigmaStartingHappiness()));
            c.setHappiness(generateStartingHappiness(
                    societyModel.getMedianStartingHappiness(),
                    societyModel.getSigmaStartingHappiness(),
                    societyModel.getMaxLevelOfHappiness()));
            citizensYearZero.add(c);
        }
    }

    private double generateStartingCash(double median, double sigma) {
        return randomDataGenerator.nextGaussian(median, sigma);
    }

    private double generateStartingHappiness(double median, double sigma, double maxHappiness) {
        double result;
        do {
            result = randomDataGenerator.nextGaussian(median,sigma);
        } while (result > maxHappiness);

        return result;
    }
}
