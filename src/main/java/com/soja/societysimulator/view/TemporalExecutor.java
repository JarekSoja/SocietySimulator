package com.soja.societysimulator.view;

import com.soja.societysimulator.appController.CitizenCreator;
import com.soja.societysimulator.appController.TimeMachine;
import com.soja.societysimulator.model.DoomsdayBook;
import com.soja.societysimulator.model.SocietyModel;

public class TemporalExecutor {

    private SocietyModel societyModel;
    private DoomsdayBook doomsdayBook;

    public TemporalExecutor(SocietyModel societyModel) {
        this.societyModel = societyModel;
        this.doomsdayBook = new DoomsdayBook();
    }

    public void execute() {
        CitizenCreator citizenCreator = new CitizenCreator();
        citizenCreator.setYearZeroPopulation(this.doomsdayBook, this.societyModel.getPopulation(), this.societyModel.getStartingCash());
        TimeMachine timeMachine = new TimeMachine(this.societyModel, this.doomsdayBook);
        timeMachine.process();
        System.out.println(this.doomsdayBook.toString());
    }
}
