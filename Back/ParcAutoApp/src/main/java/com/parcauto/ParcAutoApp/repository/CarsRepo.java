package com.parcauto.ParcAutoApp.repository;

import com.parcauto.ParcAutoApp.model.Cars;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarsRepo extends JpaRepository<Cars, Long> {
}
