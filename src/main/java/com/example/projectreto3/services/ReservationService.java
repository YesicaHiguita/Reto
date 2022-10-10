package com.example.projectreto3.services;

import com.example.projectreto3.entities.Message;
import com.example.projectreto3.entities.Reservation;
import com.example.projectreto3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int reservationId) {
        return reservationRepository.getById(reservationId);
    }

    public Reservation save(Reservation c){
        if(c.getIdReservation()==null){
            return reservationRepository.save(c);
        }else{
            Optional<Reservation> pa=reservationRepository.getById(c.getIdReservation());
            if(!pa.isPresent()){
                return reservationRepository.save(c);
            }
        }
        return c;

    }

    public Reservation update(Reservation a){
        if(a.getIdReservation()!=null){
            Optional<Reservation> pa=reservationRepository.getById(a.getIdReservation());
            if(pa.isPresent()){
                Reservation result=pa.get();

                if(a.getStartDate()!=null){
                    result.setStartDate(a.getStartDate());
                }
                if(a.getDevolutionDate()!=null){
                    result.setDevolutionDate(a.getDevolutionDate());
                }
                if(a.getStatus()!=null){
                    result.setStatus(a.getStatus());
                }

                return reservationRepository.save(result);
            }
        }
        return a;
    }

    public boolean deleteReservation (int id){
        Boolean d = getReservation(id).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return d;
    }
}
