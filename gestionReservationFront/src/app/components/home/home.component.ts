import { Component, OnInit } from '@angular/core';
import { ReservationserviceService } from 'src/app/services/reservationservice.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  totalReservations: number = 0;
  confirmedReservations: number = 0;
  canceledReservations: number = 0;

  constructor(private reservationService: ReservationserviceService) { }

  ngOnInit(): void {
    // Appeler une méthode dans le service pour récupérer les données
    this.loadReservationStats();
  }

  loadReservationStats(): void {
    // Par exemple, supposons que le service retourne des statistiques sous forme d'objet
    this.reservationService.getReservationStats().subscribe((data: any) => {
      this.totalReservations = data.total;
      this.confirmedReservations = data.confirmed;
      this.canceledReservations = data.canceled;
    });
  }

}
