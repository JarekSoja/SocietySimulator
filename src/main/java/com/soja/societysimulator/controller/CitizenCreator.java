package com.soja.societysimulator.controller;

import com.soja.societysimulator.model.Citizen;
import com.soja.societysimulator.model.DoomsdayBook;
import com.soja.societysimulator.model.SocietyModel;

import java.util.ArrayList;
import java.util.List;

public class CitizenCreator {

    private SocietyModel societyModel;
    private List<Citizen> citizensYearZero = new ArrayList<>();

    public CitizenCreator(SocietyModel societyModel) {
        this.societyModel = societyModel;
    }

    public void setYearZeroPopulation(DoomsdayBook doomsdayBook) {
        initializeCitizens();
        doomsdayBook.getCitizensByYear().put(0, citizensYearZero);
    }

    private void initializeCitizens() {

        for (int i = 0; i < societyModel.getPopulation(); i++) {
            citizensYearZero.add(new Citizen());
        }

        setCashForEachCitizen();
    }

    private void setCashForEachCitizen() {

        for (Citizen c : citizensYearZero) {
            c.setCash(societyModel.getStartingCash());
    }

}



}
