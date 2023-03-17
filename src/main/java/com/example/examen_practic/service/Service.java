package com.example.examen_practic.service;

import com.example.examen_practic.domain.Flight;
import com.example.examen_practic.observers.ConcreteObservable;
import com.example.examen_practic.observers.Observable;
import com.example.examen_practic.observers.Observer;
import com.example.examen_practic.repository.FlightRepo;
import com.example.examen_practic.repository.TicketRepo;
import com.example.examen_practic.repository.UserRepo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Service extends ConcreteObservable implements Observable {
    private final List<Observer> observers = new ArrayList<>();

    private static Service service = null;
    private final UserRepo userRepo;
    private final FlightRepo flightRepo;
    private final TicketRepo ticketRepo;


    public Service(UserRepo userRepo, FlightRepo flightRepo, TicketRepo ticketRepo) {
        this.userRepo = userRepo;
        this.flightRepo = flightRepo;
        this.ticketRepo = ticketRepo;

    }

    public synchronized static Service getInstance(UserRepo userRepo, FlightRepo flightRepo, TicketRepo ticketRepo) {
        if (service == null)
            service = new Service(userRepo, flightRepo, ticketRepo);
        return service;
    }

    public List<Flight> getAllFlights() {
        return flightRepo.findAll();
    }
}