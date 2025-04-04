import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Reservation, ReservationserviceService } from '../../services/reservationservice.service';
import { Location } from '@angular/common';  // Importer le service Location

@Component({
  selector: 'app-detail-reservations',
  templateUrl: './detail-reservations.component.html',
  styleUrls: ['./detail-reservations.component.css']
})
export class DetailReservationsComponent implements OnInit {

  reservation: Reservation | undefined;
  qrCodeUrl: string | undefined;

  constructor(
    private reservationService: ReservationserviceService,
    private route: ActivatedRoute,
    private location: Location
  ) {}

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id')); // Récupérer l'ID de la réservation à partir de l'URL
    this.reservationService.getReservationById(id).subscribe((data) => {
      this.reservation = data;
    });

    // Utiliser l'ID récupéré pour générer le QR code
    this.reservationService.generateQRCode(id).subscribe((qrCodeUrl) => {
      this.qrCodeUrl = qrCodeUrl;  // Assigne l'URL retournée à la variable qrCodeUrl
    });

  }

  goBack(): void {
    this.location.back();  // Utilise le service Location pour revenir en arrière
  }
}
