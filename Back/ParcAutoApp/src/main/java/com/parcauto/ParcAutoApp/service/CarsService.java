package com.parcauto.ParcAutoApp.service;

import com.parcauto.ParcAutoApp.model.Cars;
import com.parcauto.ParcAutoApp.model.Ventes;
import com.parcauto.ParcAutoApp.repository.CarsRepo;
import com.parcauto.ParcAutoApp.service.exeption.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


//Cette class heberge les differentes methodes CRUD de Cars qui sont des methodes prédefiini
// dans la class JpaRepository extentier par la class CarsRepo

@Service
public class CarsService {

    private final CarsRepo carsRepo;

    Ventes ventes;
    Cars cars;

    @Autowired
    public CarsService(CarsRepo carsRepo) {
        this.carsRepo = carsRepo;
    }

    //Methode qui permet d'ajouter une voiture
    public Cars addCar(Cars cars) {
        return  carsRepo.save(cars);
    }

    //Methode qui permet de lister / d'afficher toutes les voitures
    public List<Cars> findAllCars() {
        return carsRepo.findAll();
    }

    //Methode qui permet de modifier une voiture
    public Cars updateCar(Cars cars) {
        return carsRepo.save(cars);
    }

    //Methode qui permet d'effectuer de recherche de voiture
    public Cars findCarsById(Long id) {
        return carsRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Cars by id" + id + "was not found"));
    }

    //Methode qui permet de supprimer une voiture
    public void deleteCars(Long id) {
        carsRepo.deleteById(id);
    }
}