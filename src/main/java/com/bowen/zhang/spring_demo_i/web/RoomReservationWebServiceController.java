package com.bowen.zhang.spring_demo_i.web;

import com.bowen.zhang.spring_demo_i.business.domain.RoomReservation;
import com.bowen.zhang.spring_demo_i.business.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

//this will pass json data when visit api/reservations in terminal
@RestController
@RequestMapping("api/reservations")
public class RoomReservationWebServiceController {
    private final ReservationService reservationService;

    @Autowired
    public RoomReservationWebServiceController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping // return a list for json in web service controller
    public List<RoomReservation> getRoomReservations(@RequestParam(name = "date", required = false) String dateString) {
        Date date = DateUtils.createDateFromDateString(dateString);
        return this.reservationService.getRoomReservationForDate(date);
    }
}
