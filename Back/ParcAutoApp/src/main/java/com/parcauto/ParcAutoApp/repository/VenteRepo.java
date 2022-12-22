package com.parcauto.ParcAutoApp.repository;

import com.parcauto.ParcAutoApp.model.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VenteRepo extends JpaRepository<Ventes, Long> {

}
