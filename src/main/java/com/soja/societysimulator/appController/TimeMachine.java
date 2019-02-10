package com.soja.societysimulator.appController;

import com.soja.societysimulator.model.Citizen;
import com.soja.societysimulator.model.DoomsdayBook;
import com.soja.societysimulator.model.SocietyModel;

import java.util.*;

public class TimeMachine {

    private SocietyModel societyModel;
    private DoomsdayBook doomsdayBook;


    public TimeMachine(SocietyModel societyModel, DoomsdayBook doomsdayBook) {
        this.societyModel = societyModel;
        this.doomsdayBook = doomsdayBook;
    }

    public void process() {
        int numberOfIterations = societyModel.getYearsToOperate();
        while (numberOfIterations > 0) {
            createNewYear();
            numberOfIterations =- 1;
        }
    }

    private void createNewYear() {
        int year = doomsdayBook.getCitizensByYear().size();
        List<Citizen> citizens = doomsdayBook.clone(year - 1);
        calculateYear(citizens);
        doomsdayBook.getCitizensByYear().put(year, citizens);
    }


    private void calculateYear(List<Citizen> citizens) {
        for (Citizen c : citizens) {
            calculateCash(c);
            calculateHappiness(c);
        }
    }

    private void calculateCash(Citizen citizen) {
        Random random = new Random();
        double currentCash = citizen.getCash();
        boolean addCash = random.nextBoolean();
        int changeLimit = (int) this.societyModel.getCashChangeByYear();
        int temporalCash = random.nextInt(changeLimit);
        double finalCash = addCash ? currentCash + temporalCash : currentCash - temporalCash;
        citizen.setCash(finalCash);
    }


    private void calculateHappiness(Citizen citizen) {
        double happiness;
        do {
            happiness = citizen.getCash() / 10;
        } while (happiness > societyModel.getMaxLevelOfHappiness());
        citizen.setHappiness(happiness);
    }

    public SocietyModel getSocietyModel() {
        return societyModel;
    }

    public void setSocietyModel(SocietyModel societyModel) {
        this.societyModel = societyModel;
    }

    public DoomsdayBook getDoomsdayBook() {
        return doomsdayBook;
    }

    public void setDoomsdayBook(DoomsdayBook doomsdayBook) {
        this.doomsdayBook = doomsdayBook;
    }
}
