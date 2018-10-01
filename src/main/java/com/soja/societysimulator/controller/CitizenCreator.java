package com.soja.societysimulator.controller;

import com.soja.societysimulator.model.Citizen;
import com.soja.societysimulator.model.DoomsdayBook;
import com.vaadin.spring.annotation.SpringComponent;

import java.util.ArrayList;
import java.util.List;

@SpringComponent
public class CitizenCreator {

    private List<Citizen> citizensYearZero = new ArrayList<>();

    public void setYearZeroPopulation(DoomsdayBook doomsdayBook, int population, int cash) {
        initializeCitizens(population, cash);
        doomsdayBook.getCitizensByYear().put(0, citizensYearZero);
    }

    private void initializeCitizens(int population, int cash) {
        for (int i = 0; i < population; i++) {
            citizensYearZero.add(new Citizen(cash));
        }
    }
}
