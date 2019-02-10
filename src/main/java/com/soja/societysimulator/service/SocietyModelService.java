package com.soja.societysimulator.service;

import com.soja.societysimulator.model.SocietyModel;
import com.soja.societysimulator.model.dao.SocietyModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocietyModelService {

    private final SocietyModelRepository societyModelRepository;

    @Autowired
    public SocietyModelService(SocietyModelRepository societyModelRepository) {
        this.societyModelRepository = societyModelRepository;
    }

    public SocietyModel getSocietyModelById(Long id) {
        return societyModelRepository.getSocietyModelById(id);
    }

    public SocietyModel save(SocietyModel societyModel) {
        return societyModelRepository.save(societyModel);
    }
}
