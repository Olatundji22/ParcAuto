import { NgForm } from '@angular/forms';
import { AllService } from './../service/all.service';
import { Component, OnInit } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import { Ventes } from './ventes';
import { Cars } from '../cars/cars';
import { Clients } from '../clients/clients';

@Component({
  selector: 'app-ventes',
  templateUrl: './ventes.component.html',
  styleUrls: ['./ventes.component.css']
})
export class VentesComponent implements OnInit {

  public ventes: Ventes[];
  public editVentes: Ventes;
  public deleteVentes: Ventes;
  public cars: Cars[];
  public editCars: Cars;
  public clients: Clients[];
  public editClient: Clients;


  constructor(private allService: AllService) { }

  ngOnInit(): void {
    this.getVentes();
    this.getCars();
    this.getClients();
  }

  //Récupérer la liste des voiture
  public getCars(): void {
    this.allService.getCars().subscribe(
      (response: Cars[]) => {
        this.cars = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
  }

  //Récupérer la liste des clients
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


  //Afficher les ventes presentent=nt dans la base de données
  public getVentes(): void {
    this.allService.getVentes().subscribe(
      (response: Ventes[]) => {
        this.ventes = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
  }


  //Enregistrer une vente
  public onAddVentes(addForm: NgForm): void {
    document.getElementById('add-ventes-form').click();
    this.allService.addVentes(addForm.value).subscribe(
      (response: Ventes) => {
        console.log(response)
        this.getVentes();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
      )
  }


  //Modifier une vente
  public onUpdateVente(vente: Ventes) {
    this.allService.updateVentes(vente).subscribe(
      (response: Ventes) => {
        console.log(response);
      },
      (error:HttpErrorResponse) => {
        alert(error.message);
      }
    )
  }

  //Supprimer une vente
  public onDeleteVentes(venteId: number): void {
    this.allService.deleteVentes(venteId).subscribe(
      (response: void) => {
        console.log(response);
        this.getVentes();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
  }

  //Les differentes Option pour afficher le modal (Ajout, Modification et Suppression)
  public onOpenModal(ventes: Ventes, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addVentesModal');
    }
    if (mode === 'edit') {
      this.editVentes = ventes;
      button.setAttribute('data-target', '#updateVentesModal');
    }
    if (mode === 'delete') {
      this.deleteVentes = ventes;
      button.setAttribute('data-target', '#deleteVentesModal');
    }
    container.appendChild(button);
    button.click();
  }

}
