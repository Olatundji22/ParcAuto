package com.parcauto.ParcAutoApp.controller;
import com.parcauto.ParcAutoApp.model.Client;
import com.parcauto.ParcAutoApp.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    public ClientService clientService;

    public ClientController (ClientService clientService) {
        this.clientService = clientService;
    }

    //Lister les Clients
    @GetMapping("/all")
    public ResponseEntity<List<Client>> getAllClient() {
        List<Client> clientList = clientService.findAllClient();
        return new ResponseEntity<>(clientList, HttpStatus.OK);
    }

    //Afficher un clien grace à son ID
    @GetMapping("/find/{id}")
    public ResponseEntity<Client> getClientById (@PathVariable("id") Long id) {
        Client client = clientService.findClientById(id);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    //Ajouter un client
    @PostMapping("/add")
    public ResponseEntity<Client> addClient(@RequestBody Client client) {
        Client newClient = clientService.addClient(client);
        return new ResponseEntity<>(newClient, HttpStatus.CREATED);
    }

    //Modifier un client
    @PutMapping("/update")
    public ResponseEntity<Client> updateClient(@RequestBody Client client) {
        Client updateClient = clientService.updateClient(client);
        return new ResponseEntity<>(updateClient, HttpStatus.OK);
    }

    //Supprimer un client
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable("id") Long id) {
        clientService.deleteClient(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
