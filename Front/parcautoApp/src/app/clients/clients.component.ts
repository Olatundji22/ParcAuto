import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AllService } from '../service/all.service';
import { Clients } from './clients';
import { } from '@fortawesome/angular-fontawesome'

@Component({
  selector: 'app-clients',
  templateUrl: './clients.component.html',
  styleUrls: ['./clients.component.css']
})
export class ClientsComponent implements OnInit {

  public clients: Clients[];
  public editClient: Clients;
  public deleteClients: Clients;

  constructor(private allService: AllService) { }

  ngOnInit(): void {
    this.getClients();
  }

  //Afficher les clients present dans la base de données
  public getClients(): void {
    this.allService.getClients().subscribe(
      (response: Clients[]) => {
        this.clients = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
  }


  //Enregistrer un client
  public onAddClients(addForm: NgForm): void {
    document.getElementById('add-client-form').click();
    this.allService.addClients(addForm.value).subscribe(
      (response: Clients) => {
        console.log(response);
        this.getClients();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
  }


  //Modifier un client
  public onUpdateClients(clients: Clients): void {
    this.allService.updateClients(clients).subscribe(
      (response: Clients) => {
        console.log(response);
        this.getClients();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
  }


  //Supprimer un client
  public onDeleteClients(clientId: number): void {
    this.allService.deleteClients(clientId).subscribe(
      (response: void) => {
        console.log(response);
        this.getClients();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
  }


  //Effectuer une recherche de client dans la barre de recherche
  public searchClients(key: string): void {
    console.log(key);
    const result: Clients[] = [];
    for(const clients of this.clients) {
      if (clients.nom.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || clients.prenom.toLowerCase().indexOf(key.toLowerCase()) !== -1
      ) {
        result.push(clients);
      }
    }
    this.clients = result;
    if (result.length === 0 || !key) {
      this.getClients();
    }


  }


  //Les differentes Option pour afficher le modal (Ajout, Modification et Suppression)
  public onOpenModal(clients: Clients, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addClientsModal');
    }
    if (mode === 'edit') {
      this.editClient = clients;
      button.setAttribute('data-target', '#updateClientsModal');
    }
    if (mode === 'delete') {
      this.deleteClients = clients;
      button.setAttribute('data-target', '#deleteClientsModal');
    }
    container.appendChild(button);
    button.click();
  }
}
