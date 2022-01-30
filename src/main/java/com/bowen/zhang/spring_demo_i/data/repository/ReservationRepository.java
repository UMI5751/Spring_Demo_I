package com.bowen.zhang.spring_demo_i.data.repository;

import com.bowen.zhang.spring_demo_i.data.entity.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.sql.rowset.CachedRowSet;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {
}