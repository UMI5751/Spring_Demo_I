package com.bowen.zhang.spring_demo_i.business.service;

import com.bowen.zhang.spring_demo_i.business.domain.RoomReservation;
import com.bowen.zhang.spring_demo_i.data.entity.Guest;
import com.bowen.zhang.spring_demo_i.data.entity.Reservation;
import com.bowen.zhang.spring_demo_i.data.entity.Room;
import com.bowen.zhang.spring_demo_i.data.repository.GuestRepository;
import com.bowen.zhang.spring_demo_i.data.repository.ReservationRepository;
import com.bowen.zhang.spring_demo_i.data.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service //for component scanning, indicate this class is a bean
public class ReservationService {
    private final RoomRepository roomRepository;
    private final ReservationRepository reservationRepository;
    private final GuestRepository guestRepository;

    @Autowired //annotated on constructor
    public ReservationService(RoomRepository roomRepository, ReservationRepository reservationRepository, GuestRepository guestRepository) {
        this.roomRepository = roomRepository;
        this.reservationRepository = reservationRepository;
        this.guestRepository = guestRepository;
    }

    public List<RoomReservation> getRoomReservationForDate (Date date) {
        Iterable<Room> rooms = this.roomRepository.findAll();
        Map<Long, RoomReservation> roomReservationMap = new HashMap<>();
        rooms.forEach(room -> { //populate all rooms
            RoomReservation roomReservation = new RoomReservation();
            roomReservation.setRoomID(room.getRoomId());
            roomReservation.setRoomNumber(room.getRoomNumber());
            roomReservation.setRoomName(room.getRoomName());
            roomReservationMap.put(room.getRoomId(), roomReservation);
        });

        Iterable<Reservation> reservations = this.reservationRepository.findReservationByReservationDate(new java.sql.Date(date.getTime()));
        reservations.forEach(reservation -> {
            RoomReservation roomReservation = roomReservationMap.get(reservation.getRoomID());
            roomReservation.setDate(date);
            Guest guest = this.guestRepository.findById(reservation.getGuestID()).get();
            roomReservation.setFirstName(guest.getFirstName());
            roomReservation.setLastName(guest.getLastName());
            roomReservation.setGuestID(guest.getGuestId());
        });

        List<RoomReservation> roomReservations = new ArrayList<>();
        for (Long id : roomReservationMap.keySet()) {
            roomReservations.add(roomReservationMap.get(id));
        }

        return roomReservations;
    }
}
