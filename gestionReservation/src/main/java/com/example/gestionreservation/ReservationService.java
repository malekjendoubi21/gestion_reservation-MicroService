package com.example.gestionreservation;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation addReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Reservation updateReservation(int id, Reservation newReservation) {
        return reservationRepository.findById(id).map(existingReservation -> {
            existingReservation.setDatedebut(newReservation.getDatedebut());
            existingReservation.setDatefin(newReservation.getDatefin());
            existingReservation.setIdchambre(newReservation.getIdchambre());
            existingReservation.setStatut(newReservation.getStatut());
            return reservationRepository.save(existingReservation);
        }).orElseThrow(() -> new RuntimeException("Réservation non trouvée"));
    }

    public void deleteReservation(int id) {
        if (!reservationRepository.existsById(id)) {
            throw new RuntimeException("Réservation non trouvée");
        }
        reservationRepository.deleteById(id);
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> getReservationById(int id) {
        return reservationRepository.findById(id);
    }
}
