package com.example.examen_practic.repository;

import com.example.examen_practic.domain.Utilizator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepo implements Repository<Utilizator, Integer>{
    @Override
    public Utilizator save(Utilizator entity) {
        return null;
    }

    @Override
    public Utilizator delete(Integer a) {
        return null;
    }

    @Override
    public Utilizator findOne(Integer a) {
        return null;
    }

    @Override
    public Utilizator update(Utilizator entity, Integer id) {
        return null;
    }

    private final JDBCUtils jdbcUtils = new JDBCUtils();

    @Override
    public List<Utilizator> findAll() {
        List<Utilizator> useri = new ArrayList<>();

        String query = "SELECT * from utilizatori";
        try (Connection connection = jdbcUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()
        ) {
            while (resultSet.next()) {
                int userid = resultSet.getInt("userid");
                String username = resultSet.getString("username");
                String name = resultSet.getString("name");


                Utilizator user=new Utilizator(userid, username, name);
                useri.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return useri;
    }
}