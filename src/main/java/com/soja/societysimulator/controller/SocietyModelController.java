package com.soja.societysimulator.controller;

import com.soja.societysimulator.model.DoomsdayBook;
import com.soja.societysimulator.model.SocietyModel;
import com.soja.societysimulator.service.SocietyModelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RequestMapping("/model")
@RestController
public class SocietyModelController {

    private final SocietyModelService societyModelService;

    @Autowired
    public SocietyModelController(SocietyModelService societyModelService) {
        this.societyModelService = societyModelService;
    }

    @GetMapping(value = "/[id]")
    public SocietyModel getSocietyModel(@RequestParam("id") Long id) {
        return societyModelService.getSocietyModelById(id);
    }
}
