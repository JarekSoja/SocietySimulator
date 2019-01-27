package com.soja.societysimulator.controller;

import com.soja.societysimulator.model.DoomsdayBook;
import com.soja.societysimulator.service.DoomsdayBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RequestMapping("/doomsday")
@RestController
public class DoomsdayBookController {

    private final DoomsdayBookService doomsdayBookService;

    @Autowired
    public DoomsdayBookController(DoomsdayBookService doomsdayBookService) {
        this.doomsdayBookService = doomsdayBookService;
    }

    @GetMapping(value = "/[id]")
    public DoomsdayBook getDoomsdayBookById(@RequestParam("id") Long id) {
        return doomsdayBookService.getDoomsdayBookById(id);
    }
}
