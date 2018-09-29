package com.soja.societysimulator.model.dao;

import com.soja.societysimulator.model.DoomsdayBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoomsdayBookRepository extends JpaRepository <DoomsdayBook, Long> {
}
