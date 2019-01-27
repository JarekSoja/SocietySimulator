package com.soja.societysimulator.service;

import com.soja.societysimulator.model.DoomsdayBook;
import com.soja.societysimulator.model.dao.DoomsdayBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoomsdayBookService {

    private final DoomsdayBookRepository doomsdayBookRepository;

    @Autowired
    public DoomsdayBookService(DoomsdayBookRepository doomsdayBookRepository) {
        this.doomsdayBookRepository = doomsdayBookRepository;
    }

    public DoomsdayBook saveDoomsdayBook(DoomsdayBook doomsdayBook) {
        return doomsdayBookRepository.save(doomsdayBook);
    }

    public DoomsdayBook getDoomsdayBookById(long id) {
        return doomsdayBookRepository.getDoomsdayBookById(id);
    }
}
