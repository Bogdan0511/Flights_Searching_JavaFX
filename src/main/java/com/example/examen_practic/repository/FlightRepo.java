package com.example.examen_practic.repository;

import com.example.examen_practic.domain.Flight;
import com.example.examen_practic.domain.Utilizator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FlightRepo implements Repository<Flight, Long>{
    @Override
    public Flight save(Flight entity) {
        return null;
    }

    @Override
    public Flight delete(Long a) {
        return null;
    }

    @Override
    public Flight findOne(Long a) {
        return null;
    }

    @Override
    public Flight update(Flight entity, Long id) {
        return null;
    }

    private final JDBCUtils jdbcUtils = new JDBCUtils();

    @Override
    public List<Flight> findAll() {
        List<Flight> zboruri = new ArrayList<>();

        String query = "SELECT * from zboruri";
        try (Connection connection = jdbcUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()
        ) {
            while (resultSet.next()) {
                Long flightid = resultSet.getLong("id");
                String from = resultSet.getString("from");
                String to = resultSet.getString("to");
                LocalDateTime departure = resultSet.getTimestamp("departure").toLocalDateTime();
                LocalDateTime landing = resultSet.getTimestamp("landing").toLocalDateTime();
                int seats = resultSet.getInt("seats");

                Flight zbor=new Flight(flightid, from, to, departure, landing, seats);
                zboruri.add(zbor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return zboruri;
    }
}