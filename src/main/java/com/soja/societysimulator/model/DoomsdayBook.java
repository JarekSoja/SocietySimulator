package com.soja.societysimulator.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
@Table (name = "DOOMSDAY_BOOKS")
public class DoomsdayBook {

    @Id
    @GeneratedValue
    @NotNull
    private Long id;

    @OneToMany(
            targetEntity = Citizen.class,
            mappedBy = "doomsdayBook",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @Column (name = "DOOMSDAY_BOOK_CITIZENS")
    private Map<Integer, List<Citizen>> citizensByYear;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Map<Integer, List<Citizen>> getCitizensByYear() {
        return citizensByYear;
    }

    public void setCitizensByYear(Map<Integer, List<Citizen>> citizensByYear) {
        this.citizensByYear = citizensByYear;
    }

    public void setCitizensForOneYear(int year, List<Citizen> citizens) {
        this.citizensByYear.put(year, citizens);
    }

    public List<Citizen> clone(int year) {
        List<Citizen> clonedCitizens = new ArrayList<>();
        for (Citizen c : getCitizensByYear().get(year)) {
            clonedCitizens.add(c.copy());
        }
        return clonedCitizens;
    }
}
