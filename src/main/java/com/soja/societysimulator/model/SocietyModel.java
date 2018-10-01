package com.soja.societysimulator.model;

import com.vaadin.spring.annotation.SpringComponent;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@SpringComponent
@Entity
@Table (name = "SOCIETY_MODELS")
public class SocietyModel {


    @Id
    @GeneratedValue
    @NotNull
    private Long id;

    @OneToOne (cascade = CascadeType.ALL,
               fetch = FetchType.EAGER)
    @JoinColumn (name = "DOOMSDAY_BOOKS")
    private DoomsdayBook doomsdayBook;

    @Column(name = "STARTING_CASH")
    private int startingCash;

    @Column(name = "STARTING_POPULATION")
    private int population;

    @Column(name = "CASH_CHANGE")
    private int cashChangeByYear;

    @Column(name = "YEARS")
    private int yearsToOperate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DoomsdayBook getDoomsdayBook() {
        return doomsdayBook;
    }

    public void setDoomsdayBook(DoomsdayBook doomsdayBook) {
        this.doomsdayBook = doomsdayBook;
    }

    public int getStartingCash() {
        return startingCash;
    }

    public void setStartingCash(int startingCash) {
        this.startingCash = startingCash;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getCashChangeByYear() {
        return cashChangeByYear;
    }

    public void setCashChangeByYear(int cashChangeByYear) {
        this.cashChangeByYear = cashChangeByYear;
    }

    public int getYearsToOperate() {
        return yearsToOperate;
    }

    public void setYearsToOperate(int yearsToOperate) {
        this.yearsToOperate = yearsToOperate;
    }

    public void clear() {
        setStartingCash(0);
        setCashChangeByYear(0);
        setPopulation(0);
        setYearsToOperate(0);
    }
}
