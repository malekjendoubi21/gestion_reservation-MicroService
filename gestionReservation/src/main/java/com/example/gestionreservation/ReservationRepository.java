package com.example.gestionreservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    long countByStatut(Boolean statut);

}
