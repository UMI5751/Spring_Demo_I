package com.bowen.zhang.spring_demo_i.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "RESERVATION")
public class Reservation {
    @Id
    @Column(name = "RESERVATION_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reservationId;

    @Column(name = "ROOM_ID")
    private Long roomID;

    @Column(name = "RES_DATE")
    private String resDate;

    @Column(name = "Guest_ID")
    private Long guestID;
}
