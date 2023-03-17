package com.example.examen_practic.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Ticket extends Entity<Integer>{
    String username;
    Long flightId;
    LocalDateTime purchaseTime;

    public Ticket(int ticketId, String username, Long flightId, LocalDateTime purchaseTime) {
        this.username = username;
        this.flightId = flightId;
        this.purchaseTime = purchaseTime;
        super.setId(ticketId);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public LocalDateTime getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(LocalDateTime purchaseTime) {
        this.purchaseTime = purchaseTime;
    }
}
