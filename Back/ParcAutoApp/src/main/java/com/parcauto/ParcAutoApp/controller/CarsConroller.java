package com.parcauto.ParcAutoApp.controller;

import com.parcauto.ParcAutoApp.model.Cars;
import com.parcauto.ParcAutoApp.service.CarsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarsConroller {

    public CarsService carsService;

    public CarsConroller(CarsService carsService) {
        this.carsService = carsService;
    }

    //Lister les Voitures
    @GetMapping("/all")
    public ResponseEntity<List<Cars>> getAllCars() {
        List<Cars> carsList = carsService.findAllCars();
        return new ResponseEntity<>(carsList, HttpStatus.OK);
    }

    //Afficher une voiture grace à son ID
    @GetMapping("/find/{id}")
    public ResponseEntity<Cars> getCarById (@PathVariable("id") Long id) {
        Cars cars = carsService.findCarsById(id);
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    //Ajouter une voiture
    @PostMapping("/add")
    public ResponseEntity<Cars> addCar(@RequestBody Cars cars) {
        Cars newCars = carsService.addCar(cars);
        return new ResponseEntity<>(newCars, HttpStatus.CREATED);
    }

    //Modifier une voiture
    @PutMapping("/update")
    public ResponseEntity<Cars> updateCar(@RequestBody Cars cars) {
        Cars updateCars = carsService.updateCar(cars);
        return new ResponseEntity<>(updateCars, HttpStatus.OK);
    }

    //Supprimer une voiture
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable("id") Long id) {
        carsService.deleteCars(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
