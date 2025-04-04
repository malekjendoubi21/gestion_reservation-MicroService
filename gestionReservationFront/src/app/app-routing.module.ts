import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ListreservationsComponent} from "./reservation/listreservations/listreservations.component";
import {AddreservationsComponent} from "./reservation/addreservations/addreservations.component";
import {HomeComponent} from "./components/home/home.component";
import {DetailReservationsComponent} from "./reservation/detail-reservations/detail-reservations.component";

const routes: Routes = [
  { path: '', component: HomeComponent }, // route d'accueil
  { path: 'home', component: HomeComponent },

  { path: 'listreservation', component: ListreservationsComponent },
  { path: 'reservation-detail/:id', component: DetailReservationsComponent }, // Route pour les détails

  { path: 'addreservation', component: AddreservationsComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
