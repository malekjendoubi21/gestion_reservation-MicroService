package com.example.gestionreservation;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class GestionReservationApplication {

    private final ReservationRepository reservationRepository;

    public GestionReservationApplication(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(GestionReservationApplication.class, args);
    }

    @Bean
    ApplicationRunner init() {
        return args -> {
            if (reservationRepository.count() == 0) { // Vérifie si la table est vide
                reservationRepository.saveAll(List.of(
                        new Reservation(new Date(), new Date(), 101, true),
                        new Reservation(new Date(), new Date(), 102, false),
                        new Reservation(new Date(), new Date(), 103, true),
                        new Reservation(new Date(), new Date(), 104, false),
                         new Reservation(new Date(), new Date(), 105, false)

                ));
            }

            // Afficher toutes les réservations en base
            reservationRepository.findAll().forEach(System.out::println);
        };
    }
}
