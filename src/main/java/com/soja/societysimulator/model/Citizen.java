package com.soja.societysimulator.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table (name = "CITIZENS")
public class Citizen {


    @Id
    @GeneratedValue
    @NotNull
    private Long id;

    @Column(name = "CASH_AMOUNT")
    private double cash;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "DOOMSDAY_BOOKS")
    private DoomsdayBook doomsdayBook;

    public Citizen() {
    }

    public Citizen(double cash) {
        this.cash = cash;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public DoomsdayBook getDoomsdayBook() {
        return doomsdayBook;
    }

    public void setDoomsdayBook(DoomsdayBook doomsdayBook) {
        this.doomsdayBook = doomsdayBook;
    }

    public Citizen copy () {
        return new Citizen(this.cash);
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "cash=" + cash +
                '}';
    }
}
