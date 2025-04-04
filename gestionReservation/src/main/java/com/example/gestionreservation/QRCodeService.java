package com.example.gestionreservation;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Hashtable;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Hashtable;

@Service
public class QRCodeService {

    // Chemin du répertoire pour stocker les QR codes dans static
    private static final String QR_CODE_PATH = "src/main/resources/static/qr-codes/";
    private final ReservationService reservationService;

    // Injection du service ReservationService
    public QRCodeService(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    public String generateQRCodeForReservation(int reservationId) throws IOException {
        // Récupérer la réservation par son ID
        Reservation reservation = reservationService.getReservationById(reservationId)
                .orElseThrow(() -> new IllegalArgumentException("Réservation introuvable"));

        // Préparer les informations à encoder dans le QR code (par exemple, les dates et le statut)
        String reservationData = "Réservation ID: " + reservation.getId() +
                "\nDate début: " + reservation.getDatedebut() +
                "\nDate fin: " + reservation.getDatefin() +
                "\nChambre: " + reservation.getIdchambre() +
                "\nStatut: " + (reservation.isStatut() ? "Confirmée" : "Annulée");

        // Nom du fichier pour le QR code
        String fileName = reservationId + ".png";
        Path path = Paths.get(QR_CODE_PATH, fileName);  // Sauvegarder dans le répertoire static

        // Vérifier si le fichier existe déjà et le supprimer s'il existe
        File file = path.toFile();
        if (file.exists()) {
            boolean deleted = file.delete();  // Supprimer l'image existante
            if (!deleted) {
                throw new IOException("Impossible de supprimer l'ancien QR code.");
            }
        }

        // Génération du QR code avec les données de la réservation
        try {
            Hashtable<EncodeHintType, Object> hintMap = new Hashtable<>();
            hintMap.put(EncodeHintType.MARGIN, 1);  // Définir la marge du QR code

            BitMatrix matrix = new MultiFormatWriter().encode(reservationData, BarcodeFormat.QR_CODE, 200, 200, hintMap);
            MatrixToImageWriter.writeToFile(matrix, "PNG", file);  // Sauvegarder l'image

            // Retourner l'URL publique du fichier QR code
            return "http://localhost:8082/qr-codes/" + fileName;  // L'URL publique de l'image
        } catch (Exception e) {
            throw new IOException("Erreur lors de la génération du QR Code", e);
        }
    }
}
