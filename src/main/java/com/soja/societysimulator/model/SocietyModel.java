package com.soja.societysimulator.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table
public class SocietyModel {


    @Id
    @GeneratedValue
    @NotNull
    private Long id;

    @OneToMany(
            targetEntity = Citizen.class,
            mappedBy = "societyModel",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @Column (name = "CITIZENS_SOCIETY_MODEL")
    private List<Citizen> citizens;
}
