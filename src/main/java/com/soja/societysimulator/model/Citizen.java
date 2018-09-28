package com.soja.societysimulator.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Citizen {


    @Id
    @GeneratedValue
    @NotNull
    private Long id;

    @Column(name = "CASH_AMOUNT")
    private int cash;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "SOCIETY_MODEL")
    private SocietyModel societyModel;

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

    public SocietyModel getSocietyModel() {
        return societyModel;
    }

    public void setSocietyModel(SocietyModel societyModel) {
        this.societyModel = societyModel;
    }
}
