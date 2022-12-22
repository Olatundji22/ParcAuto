import { Clients } from './../clients/clients';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Cars } from '../cars/cars';
import { Ventes } from '../ventes/ventes';


@Injectable({
  providedIn: 'root'
})
export class AllService {

  private apiServiceUrl = environment.apiBaseUrl

  constructor(private http : HttpClient) { }


  //Cars Service
  //Recuperation des cars
  public getCars(): Observable<Cars[]> {
    return this.http.get<Cars[]>(`${this.apiServiceUrl}/cars/all`);
  }

  //Ajouter une voiture dans la base
  public addCars(cars: Cars): Observable<Cars> {
    return this.http.post<Cars>(`${this.apiServiceUrl}/cars/add`, cars);
  }

  //Modifier un enregistrement
  public updateCars(cars: Cars): Observable<Cars> {
    return this.http.put<Cars>(`${this.apiServiceUrl}/cars/update`, cars);
  }

//Supprimer une voiture
  public deleteCars(carsId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServiceUrl}/cars/delete/${carsId}`);
  }


  //Clients Service
  //Recuperation des clients
  public getClients(): Observable<Clients[]> {
    return this.http.get<Clients[]>(`${this.apiServiceUrl}/client/all`);
  }

  //Ajouter un client dans la base
  public addClients(clients: Clients): Observable<Clients> {
    return this.http.post<Clients>(`${this.apiServiceUrl}/client/add`, clients);
  }

  //Modifier un enregistrement
  public updateClients(clients: Clients): Observable<Clients> {
    return this.http.put<Clients>(`${this.apiServiceUrl}/client/update`, clients);
  }

  //Supprimer un client
  public deleteClients(clientsId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServiceUrl}/client/delete/${clientsId}`);
  }


  //Ventes Service
  //Recuperation des ventes
  public getVentes(): Observable<Ventes[]> {
    return this.http.get<Ventes[]>(`${this.apiServiceUrl}/vente/all`);
  }

  //Ajouter une vente dans la base
  public addVentes(ventes: Ventes): Observable<Ventes> {
    return this.http.post<Ventes>(`${this.apiServiceUrl}/vente/add`, ventes);
  }

  //Modifier un enregistrement
  public updateVentes(ventes: Ventes): Observable<Ventes> {
    return this.http.put<Ventes>(`${this.apiServiceUrl}/vente/update`, ventes);
  }

//Supprimer une vente
  public deleteVentes(venteId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServiceUrl}/vente/delete/${venteId}`);
  }

}
