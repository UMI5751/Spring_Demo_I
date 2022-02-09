package com.bowen.zhang.spring_demo_i;

import com.bowen.zhang.spring_demo_i.data.entity.Guest;
import com.bowen.zhang.spring_demo_i.data.entity.Reservation;
import com.bowen.zhang.spring_demo_i.data.entity.Room;
import com.bowen.zhang.spring_demo_i.data.repository.GuestRepository;
import com.bowen.zhang.spring_demo_i.data.repository.ReservationRepository;
import com.bowen.zhang.spring_demo_i.data.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringDemoIApplication {

//    public static void main(String[] args) {
//        SpringApplication.run(SpringDemoIApplication.class, args);
//    }
//
//    @RestController
//    @RequestMapping("/rooms")
//    public class RoomController {
//        @Autowired
//        private RoomRepository roomRepository;
//
//        @RequestMapping
//        public Iterable<Room> getRooms() {
//            return roomRepository.findAll();
//        }
//    }
//
//    @RestController
//    @RequestMapping("/guests")
//    public class GuestController {
//        @Autowired
//        private GuestRepository guestRepository;
//
//        @RequestMapping
//        public Iterable<Guest> getGuests() {
//            return guestRepository.findAll();
//        }
//    }
//
//    @RestController
//    @RequestMapping("/reservations")
//    public class ReservationController {
//        @Autowired
//        private ReservationRepository reservationRepository;
//
//        @RequestMapping
//        public Iterable<Reservation> getReservations() {
//            return reservationRepository.findAll();
//        }
//    }

}
