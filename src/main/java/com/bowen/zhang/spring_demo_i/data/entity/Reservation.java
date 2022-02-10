package com.bowen.zhang.spring_demo_i.data.entity;

import javax.persistence.*;
import java.util.Date;

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
    private Date reservationDate;

    @Column(name = "Guest_ID")
    private Long guestID;

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public Long getRoomID() {
        return roomID;
    }

    public void setRoomID(Long roomID) {
        this.roomID = roomID;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date resDate) {
        this.reservationDate = resDate;
    }

    public Long getGuestID() {
        return guestID;
    }

    public void setGuestID(Long guestID) {
        this.guestID = guestID;
    }
}
