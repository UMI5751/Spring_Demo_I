package com.bowen.zhang.spring_demo_i.data.repository;

import com.bowen.zhang.spring_demo_i.data.entity.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    Iterable<Reservation> findReservationByReservationDate(Date date);// this method is automatically implemented
    // relating to its name,
    // findReservationByReservationDate means "return reservation by variable field "reservationDate"", this will be
    // done by springboot automatically
}
