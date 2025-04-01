package com.example.reservation.service;


import com.example.reservation.entity.Reservation;
import com.example.reservation.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements IReservationService {
    @Autowired
    ReservationRepository reservationRepository;

    public List<Reservation> retrieveAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation retrieveReservation(String reservationId) {
        return reservationRepository.findById(reservationId).get();
    }

    public Reservation addReservation(Reservation r) {
        return reservationRepository.save(r);
    }

    public Reservation modifyReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

//    public List<Reservation> trouverResSelonDateEtStatus(Date d, boolean b) {
//        return reservationRepository.findAllByAnneeUniversitaireBeforeAndEstValide(d, b);
//    }

    public void removeReservation(String reservationId) {
        reservationRepository.deleteById(reservationId);
    }
}
