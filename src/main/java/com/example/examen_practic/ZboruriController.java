package com.example.examen_practic;

import com.example.examen_practic.domain.Flight;
import com.example.examen_practic.domain.Utilizator;
import com.example.examen_practic.observers.Observer;
import com.example.examen_practic.repository.FlightRepo;
import com.example.examen_practic.repository.TicketRepo;
import com.example.examen_practic.repository.UserRepo;
import com.example.examen_practic.service.Service;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class ZboruriController implements Observer {

    Utilizator who;
    UserRepo repo1 = new UserRepo();
    FlightRepo repo2 = new FlightRepo();

    TicketRepo repo3 = new TicketRepo();


    Service service = Service.getInstance(repo1, repo2, repo3);

    private final ObservableList<Flight> flightModel = FXCollections.observableArrayList();

    private final ObservableList<String> locationModel = FXCollections.observableArrayList();

    @FXML
    private TableView<Flight> zboruri;
    @FXML
    private TableColumn<Flight, String> from;
    @FXML
    private TableColumn<Flight, String> to;
    @FXML
    private TableColumn<Flight, LocalDateTime> departureTime;
    @FXML
    private TableColumn<Flight, LocalDateTime> landingTime;
    @FXML
    private TableColumn<Flight, Integer> seats;
    @FXML
    private ComboBox<String> combo1;
    @FXML
    private ComboBox<String> combo2;
    @FXML
    private DatePicker datap;

    @FXML
    public Label cine ;

    public void initmodel() {
        List<Flight> flights=new ArrayList<>();
        List<String> locatii=new ArrayList<>();
        for(Flight flight : service.getAllFlights()){
            flights.add(flight);
            locatii.add(flight.getFrom());
            locatii.add(flight.getTo());
        }
        flightModel.setAll(flights);
        Set<String> set = new HashSet<>(locatii);
        locatii.clear();
        locatii.addAll(set);
        locationModel.setAll(locatii);
        combo1.setItems(locationModel);
        combo2.setItems(locationModel);
    }

    public void initmodelFiltrate() {
        List<Flight> zboruri=new ArrayList<>();

        String plecare = combo1.getValue();
        String sosire = combo2.getValue();

        for(Flight zbor : service.getAllFlights()){
            if(Objects.equals(zbor.getFrom(), plecare) && Objects.equals(zbor.getTo(), sosire)) {
                zboruri.add(zbor);
            }
        }
        flightModel.setAll(zboruri);
    }

    public void initmodelFiltrateOra() {
        List<Flight> zboruri=new ArrayList<>();
        List<Flight> finale = new ArrayList<>();
        List<Flight> toate = new ArrayList<>();
        toate = service.getAllFlights();

        String plecare = combo1.getValue();
        String sosire = combo2.getValue();

        for(Flight zbor : service.getAllFlights()){
            if(Objects.equals(zbor.getFrom(), plecare) && Objects.equals(zbor.getTo(), sosire)) {
                zboruri.add(zbor);
            }
        }
        LocalDateTime cand= datap.getValue().atStartOfDay();

        if(sosire == null) {
            for(Flight zbor : toate) {
                if(zbor.getDepartureTime().getDayOfYear() == cand.getDayOfYear()) {
                    finale.add(zbor);
                }
            }
        }
        else {
            for(Flight zbor : zboruri) {
                if(zbor.getDepartureTime().getDayOfYear() == cand.getDayOfYear()) {
                    finale.add(zbor);
                }
            }
        }
        flightModel.setAll(finale);
    }

    public void setWho(Utilizator user) {
        this.who = user;
    }


    @FXML
    private void initialize() {
        from.setCellValueFactory(new PropertyValueFactory<>("from"));
        to.setCellValueFactory(new PropertyValueFactory<>("to"));
        departureTime.setCellValueFactory(new PropertyValueFactory<>("departureTime"));
        landingTime.setCellValueFactory(new PropertyValueFactory<>("landingTime"));
        seats.setCellValueFactory(new PropertyValueFactory<>("seats"));
        zboruri.setItems(flightModel);
        initmodel();
        service.addObserver(this);
    }

    @Override
    public void update() {
        initialize();
    }
}
