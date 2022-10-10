package com.example.projectreto3.repository;

import com.example.projectreto3.entities.Reservation;
import com.example.projectreto3.repository.crud.ReservationCRUDrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCRUDrepository reservationCRUDrepository;

    public List<Reservation> getAll() {
        return (List<Reservation>) reservationCRUDrepository.findAll();
    }

    public Optional<Reservation> getById(int id) {
        return reservationCRUDrepository.findById(id);
    }


    public Reservation save(Reservation reservation) {return reservationCRUDrepository.save(reservation);}

    public void delete(Reservation reservation){
        reservationCRUDrepository.delete(reservation);
    }
}
