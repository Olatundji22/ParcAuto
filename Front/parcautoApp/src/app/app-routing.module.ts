import { CarsComponent } from './cars/cars.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClientsComponent } from './clients/clients.component';
import { VentesComponent } from './ventes/ventes.component';

const routes: Routes = [
  { path: 'car', component: CarsComponent },
  { path: 'client', component: ClientsComponent },
  { path: 'vente', component: VentesComponent },
  { path: '', redirectTo: '/car', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
