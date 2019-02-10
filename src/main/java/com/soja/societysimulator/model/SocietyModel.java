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
    private double startingCash;

    @Column(name = "STARTING_POPULATION")
    private int population;

    @Column(name = "MEDIAN_STARTING_CASH")
    private double medianStartingCash;

    @Column(name = "SIGMA_STARTING_CASH")
    private double sigmaStartingCash;

    @Column(name = "CASH_CHANGE")
    private double cashChangeByYear;

    @Column(name = "MEDIAN_STARTING_HAPPINESS")
    private double medianStartingHappiness;

    @Column(name = "SIGMA_STARTING_HAPPINESS")
    private double sigmaStartingHappiness;

    @Column(name = "MAX_LEVEL_OF_HAPPINESS")
    private double maxLevelOfHappiness;

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

    public double getStartingCash() {
        return startingCash;
    }

    public void setStartingCash(double startingCash) {
        this.startingCash = startingCash;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getCashChangeByYear() {
        return cashChangeByYear;
    }

    public void setCashChangeByYear(double cashChangeByYear) {
        this.cashChangeByYear = cashChangeByYear;
    }

    public int getYearsToOperate() {
        return yearsToOperate;
    }

    public void setYearsToOperate(int yearsToOperate) {
        this.yearsToOperate = yearsToOperate;
    }

    public double getMedianStartingCash() {
        return medianStartingCash;
    }

    public void setMedianStartingCash(double medianStartingCash) {
        this.medianStartingCash = medianStartingCash;
    }

    public double getSigmaStartingCash() {
        return sigmaStartingCash;
    }

    public void setSigmaStartingCash(double sigmaStartingCash) {
        this.sigmaStartingCash = sigmaStartingCash;
    }

    public double getMedianStartingHappiness() {
        return medianStartingHappiness;
    }

    public void setMedianStartingHappiness(double medianStartingHappiness) {
        this.medianStartingHappiness = medianStartingHappiness;
    }

    public double getSigmaStartingHappiness() {
        return sigmaStartingHappiness;
    }

    public void setSigmaStartingHappiness(double sigmaStartingHappiness) {
        this.sigmaStartingHappiness = sigmaStartingHappiness;
    }

    public double getMaxLevelOfHappiness() {
        return maxLevelOfHappiness;
    }

    public void setMaxLevelOfHappiness(double maxLevelOfHappiness) {
        this.maxLevelOfHappiness = maxLevelOfHappiness;
    }

    public void clear() {
        setStartingCash(0);
        setCashChangeByYear(0);
        setPopulation(0);
        setYearsToOperate(0);
    }
}
