import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AllService } from '../service/all.service';
import { Cars } from './cars';

@Component({
  selector: 'app-cars',
  templateUrl: './cars.component.html',
  styleUrls: ['./cars.component.css']
})
export class CarsComponent implements OnInit {

  public cars: Cars[];
  public editCars: Cars;
  public deleteCars: Cars;

  constructor(private allService: AllService) { }

  ngOnInit(): void {
    this.getCars();
  }

  //Afficher les voiture presentent dans la base de données
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

  //Enregistrer une voiture
  public onAddCars(addForm: NgForm): void {
    document.getElementById('add-cars-form').click();
    this.allService.addCars(addForm.value).subscribe(
      (response: Cars) => {
        console.log(response);
        this.getCars();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
  }


  //Modifier une voiture
  public onUpdateCars(cars: Cars): void {
    this.allService.updateCars(cars).subscribe(
      (response: Cars) => {
        console.log(response);
        this.getCars();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
  }


  //Supprimer une voiture
  public onDeleteCars(carsId: number): void {
    this.allService.deleteCars(carsId).subscribe(
      (response: void) => {
        console.log(response);
        this.getCars();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
  }


  //Effectuer une recherche dans la barre de recherche
  public serchCars(key: string): void {
    console.log(key);
    const results: Cars[] = [];
    for (const cars of this.cars) {
      if (cars.marque.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || cars.modele.toLowerCase().indexOf(key.toLowerCase()) !== -1
      ) {
        results.push(cars);
      }
    }
    this.cars = results;
    if (results.length === 0 || !key) {
      this.getCars();
    }
  }


  //Les differentes Option pour afficher le modal (Ajout, Modification et Suppression)
  public onOpenModal(cars: Cars, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addCarsModal');
    }
    if (mode === 'edit') {
      this.editCars = cars;
      button.setAttribute('data-target', '#updateCarsModal');
    }
    if (mode === 'delete') {
      this.deleteCars = cars;
      button.setAttribute('data-target', '#deleteCarsModal');
    }
    container.appendChild(button);
    button.click();
  }

}
