package com.parcauto.ParcAutoApp.repository;
import com.parcauto.ParcAutoApp.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ClientRepo extends JpaRepository<Client, Long> {

}
