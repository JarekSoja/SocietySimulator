package com.soja.societysimulator.controller;

import com.soja.societysimulator.model.Citizen;
import com.soja.societysimulator.service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*")
@RequestMapping("/citizen")
@RestController
public class CitizenController {

    private final CitizenService citizenService;

    @Autowired
    public CitizenController(CitizenService citizenService) {
        this.citizenService = citizenService;
    }

    @GetMapping
    public Citizen getCitizenById(@RequestParam("id") Long id) {
        return citizenService.getCitizenById(id);
    }
}
