package com.soja.societysimulator.model.dao;

import com.soja.societysimulator.model.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitizenRepository extends JpaRepository <Citizen, Long> {
}
