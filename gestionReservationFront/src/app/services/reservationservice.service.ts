import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Reservation {
  id?: number;
  datedebut: Date;
  datefin: Date;
  idchambre: number;
  statut: boolean;
}

@Injectable({
  providedIn: 'root'
})
export class ReservationserviceService {
  private apiUrl = 'http://localhost:8082/reservations';
  private apiUrll = 'http://localhost:8082/reservations/stats';
  private qrCodeApiUrl = 'http://localhost:8082/reservations/qrcode';  // URL pour générer le QR code

  constructor(private http: HttpClient) { }

  getAllReservations(): Observable<Reservation[]> {
    return this.http.get<Reservation[]>(this.apiUrl);
  }

  getReservationById(id: number): Observable<Reservation> {
    return this.http.get<Reservation>(`${this.apiUrl}/${id}`);
  }

  createReservation(reservation: {
    datedebut: string;
    datefin: string;
    idchambre: number;
    statut: boolean
  }): Observable<Reservation> {
    return this.http.post<Reservation>(this.apiUrl, reservation);
  }

  updateReservation(id: number, reservation: Reservation): Observable<Reservation> {
    return this.http.put<Reservation>(`${this.apiUrl}/${id}`, reservation);
  }

  deleteReservation(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
  getReservationStats(): Observable<any> {
    return this.http.get<any>(this.apiUrll);
  }
  generateQRCode(id: number): Observable<any> {
    return this.http.get<any>(`${this.qrCodeApiUrl}/${id}`, { responseType: 'text' as 'json' });
  }

}
