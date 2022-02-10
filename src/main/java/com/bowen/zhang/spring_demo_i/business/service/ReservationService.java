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
    public ReservationService(RoomRepository roomRepository, ReservationRepository reservationRepository,
                              GuestRepository guestRepository) {
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

        Iterable<Reservation> reservations =
                this.reservationRepository.findReservationByReservationDate(new java.sql.Date(date.getTime()));
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

        roomReservations.sort(new Comparator<RoomReservation>() { //sort the room numbers
            @Override
            public int compare(RoomReservation o1, RoomReservation o2) {
                if (o1.getRoomName() == o2.getRoomName()){
                    return o1.getRoomNumber().compareTo(o2.getRoomNumber());
                }
                return o1.getRoomName().compareTo(o2.getRoomName());
            }
        });

        return roomReservations;
    }

    public List<Guest> getHotelGuests() {
        Iterable<Guest> guests = this.guestRepository.findAll();
        List<Guest> guestsList = new ArrayList<>();
        guests.forEach(guest -> {
            guestsList.add(guest);
        });

        guestsList.sort(new Comparator<Guest>() {
            @Override
            public int compare(Guest o1, Guest o2) {
                if (o1.getLastName() == o2.getLastName()) {
                    return o1.getFirstName().compareTo(o2.getFirstName());
                } else {
                    return o1.getLastName().compareTo(o2.getLastName());
                }
            }
        });


        return guestsList;
    }
}
