package com.bowen.zhang.spring_demo_i.web;

import com.bowen.zhang.spring_demo_i.business.domain.RoomReservation;
import com.bowen.zhang.spring_demo_i.business.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/reservations") // tell spring all request mapping to /reservations will be responded by this class
public class RoomReservationWebController {
    private final ReservationService reservationService;

    @Autowired
    public RoomReservationWebController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public String getReservations(@RequestParam(value = "date", required = false) String dateString, Model model) {
        //take date from request parameter
        Date date = DateUtils.createDateFromDateString(dateString);
        List<RoomReservation> roomReservations = this.reservationService.getRoomReservationForDate(date);
        model.addAttribute("roomReservations", roomReservations); // pass roomReservations arraylist to model,
        // named roomReservations. this could be used in html file
        return "reservations"; // tell timeleaf engine to find a template named reservations(reservations.html) and
        // also pass the model to it.
    }
}
