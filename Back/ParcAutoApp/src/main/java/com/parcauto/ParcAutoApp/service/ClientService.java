package com.parcauto.ParcAutoApp.service;
import com.parcauto.ParcAutoApp.model.Client;
import com.parcauto.ParcAutoApp.repository.ClientRepo;
import com.parcauto.ParcAutoApp.service.exeption.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

//Cette class heberge les differentes methodes CRUD de Client qui sont des methodes prédefiini
// dans la class JpaRepository extentier par la class CarsRepo

@Service
public class ClientService {

    private final ClientRepo clientRepo;
    Client client;

    @Autowired
    public ClientService(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    //Methode qui permet d'ajouter un client
    public Client addClient(Client client) {
        client.setCodeClient(UUID.randomUUID().toString());
        return clientRepo.save(client);
    }

    //Methode qui permet de lister / d'afficher toutes les clients
    public List<Client> findAllClient() {
        return clientRepo.findAll();
    }

    //Methode qui permet de modifier un client
    public Client updateClient(Client client) {
        return clientRepo.save(client);
    }

    //Methode qui permet d'effectuer une recherche de client
    public Client findClientById(Long id) {
        return clientRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Client by id" + id + "was not found"));
    }

    //Methode qui permet de supprimer un client
    public void deleteClient(Long id) {
        clientRepo.deleteById(id);
    }
}
