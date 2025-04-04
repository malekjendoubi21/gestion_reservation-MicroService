import {Component, OnInit} from '@angular/core';
import { ReservationserviceService, Reservation } from '../../services/reservationservice.service';

@Component({
  selector: 'app-listreservations',
  templateUrl: './listreservations.component.html',
  styleUrls: ['./listreservations.component.css']
})
export class ListreservationsComponent  implements OnInit {
  reservations: Reservation[] = [];

  constructor(private reservationService: ReservationserviceService) {}

  ngOnInit(): void {
    this.loadReservations();
  }

  loadReservations(): void {
    this.reservationService.getAllReservations().subscribe({
      next: (data) => this.reservations = data,
      error: (err) => console.error('Erreur chargement des réservations', err)
    });
  }

  deleteReservation(id: number): void {
    this.reservationService.deleteReservation(id).subscribe(() => {
      this.loadReservations(); // refresh après suppression
    });
  }
}
