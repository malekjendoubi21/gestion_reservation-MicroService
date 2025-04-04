import { Component } from '@angular/core';
import { ReservationserviceService } from '../../services/reservationservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-addreservations',
  templateUrl: './addreservations.component.html',
  styleUrls: ['./addreservations.component.css']
})
export class AddreservationsComponent {
  reservation = {
    datedebut: '',
    datefin: '',
    idchambre: 0,
    statut: true
  };

  constructor(private reservationService: ReservationserviceService, private router: Router) {}

  saveReservation() {
    this.reservationService.createReservation(this.reservation).subscribe(() => {
      alert('Réservation ajoutée avec succès ✅');
      this.router.navigate(['/listreservation']);
    });
  }
}
