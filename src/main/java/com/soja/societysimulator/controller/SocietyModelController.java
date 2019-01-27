package com.soja.societysimulator.controller;

import com.soja.societysimulator.model.SocietyModel;
import com.soja.societysimulator.service.SocietyModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RequestMapping("/model")
@RestController
public class SocietyModelController {

    private final SocietyModelService societyModelService;

    @Autowired
    public SocietyModelController(SocietyModelService societyModelService) {
        this.societyModelService = societyModelService;
    }

    @GetMapping
    public SocietyModel getSocietyModel(@RequestParam("id") Long id) {
        return societyModelService.getSocietyModelById(id);
    }
}
