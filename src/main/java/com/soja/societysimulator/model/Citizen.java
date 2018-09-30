package com.soja.societysimulator.model;

import org.springframework.context.annotation.Configuration;

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
    private int cash;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "DOOMSDAY_BOOKS")
    private DoomsdayBook doomsdayBook;

    public Citizen() {
    }

    public Citizen(int cash) {
        this.cash = cash;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
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
}
