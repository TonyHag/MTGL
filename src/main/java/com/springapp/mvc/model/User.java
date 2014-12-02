package com.springapp.mvc.model;

/**
 * Created by eirikskogland on 02.12.14.
 */
public class User {

    private String username, password, email;
    private int id, wins, losses;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;

        id = 0;
        wins = 0;
        losses = 0;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }
}
