package com.example.examen_practic.domain;

public class Utilizator extends Entity<Integer>{
    String username;

    String name;

    public Utilizator(int userid, String username, String name) {
        this.username = username;
        this.name = name;
        super.setId(userid);
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
