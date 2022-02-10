package com.bowen.zhang.spring_demo_i.web;

import com.bowen.zhang.spring_demo_i.business.domain.RoomReservation;
import com.bowen.zhang.spring_demo_i.business.service.ReservationService;
import com.bowen.zhang.spring_demo_i.data.repository.ReservationRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(RoomReservationWebController.class)//declare test which class
public class RoomReservationWebControllerTest {

    @MockBean // create mock instance of dependency
    private ReservationService reservationService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getReservations() throws Exception {
        String dateString = "2020-01-01";
        Date date = DateUtils.createDateFromDateString(dateString);
        List<RoomReservation> roomReservations = new ArrayList<>();
        RoomReservation roomReservation = new RoomReservation();
        roomReservation.setRoomID(100);
        roomReservation.setGuestID(1);
        roomReservation.setLastName("Unit");
        roomReservation.setFirstName("JUnit");
        roomReservation.setRoomName("Junit Room");
        roomReservation.setDate(date);
        roomReservations.add(roomReservation);

        given(reservationService.getRoomReservationForDate(date)).willReturn(roomReservations);//define mock
        // behavior, what should be returned when getRoomReservationForDate is called

        this.mockMvc.perform(get("/reservations?date=2020-01-01"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Unit, JUnit")));
    }


}
