package com.soja.societysimulator.model.dao;

import com.soja.societysimulator.model.SocietyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface SocietyModelRepository extends JpaRepository <SocietyModel, Long> {
}
