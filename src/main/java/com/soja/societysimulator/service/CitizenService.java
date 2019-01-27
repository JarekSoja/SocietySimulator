package com.soja.societysimulator.service;

import com.soja.societysimulator.model.Citizen;
import com.soja.societysimulator.model.dao.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CitizenService {

    private final CitizenRepository citizenRepository;

    @Autowired
    public CitizenService(CitizenRepository citizenRepository) {
        this.citizenRepository = citizenRepository;
    }

    public Citizen saveCitizen(Citizen citizen) {
        return citizenRepository.save(citizen);
    }

    public Citizen getCitizenById(Long id) {
        return citizenRepository.getCitizenById(id);
    }
}