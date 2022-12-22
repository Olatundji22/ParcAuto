package com.parcauto.ParcAutoApp.controller;

import com.parcauto.ParcAutoApp.model.Client;
import com.parcauto.ParcAutoApp.model.Ventes;
import com.parcauto.ParcAutoApp.service.VenteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vente")
public class VenteController {

    public VenteService venteService;

    public VenteController(VenteService venteService) {
        this.venteService = venteService;
    }

    //Lister les Ventes
    @GetMapping("/all")
    public ResponseEntity<List<Ventes>> getAllVente() {
        List<Ventes> venteList = venteService.findAllVente();
        return new ResponseEntity<>(venteList, HttpStatus.OK);
    }

    //Afficher une vente grace à son ID
    @GetMapping("/find/{id}")
    public ResponseEntity<Ventes> getVenteById (@PathVariable("id") Long id) {
        Ventes ventes = venteService.findVenteById(id);
        return new ResponseEntity<>(ventes, HttpStatus.OK);
    }

    //Ajouter une vente
    @PostMapping("/add")
    public ResponseEntity<Ventes> addVente(@RequestBody Ventes ventes) {
        Ventes newVente = venteService.addVente(ventes);
        return new ResponseEntity<>(newVente, HttpStatus.CREATED);
    }

    //Modifier une vente
    @PutMapping("/update")
    public ResponseEntity<Ventes> updateVente(@RequestBody Ventes ventes) {
        Ventes updateVente = venteService.updateVente(ventes);
        return new ResponseEntity<>(updateVente, HttpStatus.OK);
    }

    //Supprimer une vente
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteVente(@PathVariable("id") Long id) {
        venteService.deleteVente(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
