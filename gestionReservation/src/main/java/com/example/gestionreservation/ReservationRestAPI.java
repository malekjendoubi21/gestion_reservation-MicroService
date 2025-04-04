package com.example.gestionreservation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/reservations")
public class ReservationRestAPI {

    private final ReservationService reservationService;
    private final QRCodeService qrCodeService;  // Injection de QRCodeService

    // Injection des services ReservationService et QRCodeService
    public ReservationRestAPI(ReservationService reservationService, QRCodeService qrCodeService) {
        this.reservationService = reservationService;
        this.qrCodeService = qrCodeService;
    }

    /*@PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        return ResponseEntity.ok(reservationService.addReservation(reservation));
    }
*/
    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        Reservation createdReservation = reservationService.addReservation(reservation);

        // Générer le QR code pour la réservation créée
        try {
            String qrCodeUrl = qrCodeService.generateQRCodeForReservation(createdReservation.getId());
            System.out.println("QR Code généré pour la réservation : " + createdReservation.getId() + " - Chemin: " + qrCodeUrl);
        } catch (Exception e) {
            System.out.println("Erreur lors de la génération du QR Code pour la réservation " + reservation.getId());
            e.printStackTrace();
        }

        return ResponseEntity.ok(createdReservation);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable int id, @RequestBody Reservation reservation) {
        return ResponseEntity.ok(reservationService.updateReservation(id, reservation));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable int id) {
        reservationService.deleteReservation(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservations() {
        return ResponseEntity.ok(reservationService.getAllReservations());
    }

 /*  @GetMapping("/{id}")
    public ResponseEntity<Optional<Reservation>> getReservationById(@PathVariable int id) {
        return ResponseEntity.ok(reservationService.getReservationById(id));
    }*/
 @GetMapping("/{id}")
 public ResponseEntity<Optional<Reservation>> getReservationById(@PathVariable int id) {
     Optional<Reservation> reservation = reservationService.getReservationById(id);

     // Générer le QR code pour la réservation récupérée
     reservation.ifPresent(res -> {
         try {
             String qrCodeUrl = qrCodeService.generateQRCodeForReservation(res.getId());
             System.out.println("QR Code généré pour la réservation : " + res.getId() + " - Chemin: " + qrCodeUrl);
         } catch (Exception e) {
             System.out.println("Erreur lors de la génération du QR Code pour la réservation " + res.getId());
             e.printStackTrace();
         }
     });

     return ResponseEntity.ok(reservation);
 }
    @GetMapping("/stats")
    public ResponseEntity<Map<String, Integer>> getReservationStats() {
        Map<String, Integer> stats = new HashMap<>();
        stats.put("total", reservationService.getTotalReservations());
        stats.put("confirmed", reservationService.getConfirmedReservations());
        stats.put("canceled", reservationService.getCanceledReservations());

        return ResponseEntity.ok(stats);
    }
    @GetMapping("/qrcode/{id}")
    public ResponseEntity<String> generateQRCode(@PathVariable int id) {
        try {
            // Appeler le service pour générer le QR code
            String qrCodeUrl = qrCodeService.generateQRCodeForReservation(id);

            // Retourner l'URL du QR code généré
            return ResponseEntity.ok(qrCodeUrl);  // L'URL publique du QR code
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de la génération du QR Code");
        }
    }


}
