package com.soja.societysimulator.model.dao;

import com.soja.societysimulator.model.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface CitizenRepository extends JpaRepository <Citizen, Long> {
    Citizen getCitizenById(Long id);
}
