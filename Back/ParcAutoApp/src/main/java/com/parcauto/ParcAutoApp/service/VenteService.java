package com.parcauto.ParcAutoApp.service;
import com.parcauto.ParcAutoApp.model.Cars;
import com.parcauto.ParcAutoApp.model.Ventes;
import com.parcauto.ParcAutoApp.repository.VenteRepo;
import com.parcauto.ParcAutoApp.service.exeption.UserNotFoundException;
import org.springframework.stereotype.Service;

//import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;
import java.util.Date;

@Service
public class VenteService {

    private final VenteRepo venteRepo;

    public Cars cars;

    public VenteService(VenteRepo venteRepo) {
        this.venteRepo = venteRepo;
    }

    //Methode qui permet d'ajouter une vente
    public Ventes addVente(Ventes ventes) {
        ventes.setCodeVente(UUID.randomUUID().toString());
        Date today = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        ventes.setDate(dateFormat.format((today)));
        return venteRepo.save(ventes);
    }

    //Methode qui permet de lister / d'afficher toutes les ventes
    public List<Ventes> findAllVente() {
        return venteRepo.findAll();
    }

    //Methode qui permet de modifier une vente
    public Ventes updateVente(Ventes ventes) {
        return venteRepo.save(ventes);
    }

    //Methode qui permet d'effectuer une recherche d'une vente'
    public Ventes findVenteById(Long id) {
        return venteRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Vente by id" + id + "was not found"));
    }

    //Methode qui permet de supprimer une vente
    public void deleteVente(Long id) {
        venteRepo.deleteById(id);
    }
}
