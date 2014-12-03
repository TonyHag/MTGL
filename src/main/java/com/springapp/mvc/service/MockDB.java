package com.springapp.mvc.service;

import com.springapp.mvc.model.Game;
import com.springapp.mvc.model.User;

import java.util.ArrayList;

/**
 * Created by eirikskogland on 02.12.14.
 * Gidder ikke sette opp ekte database, så det får holde med en mock med samme funksjonalitet,
 * så blir det enkelt å sette opp en ekte utifra denne.
 */
public class MockDB {

    public static ArrayList<User> users = new ArrayList<User>();
    public static ArrayList<Game> games = new ArrayList<Game>();

    // Sjekker om et brukernavn eksisterer
    public static boolean isUser (String username){
        boolean isUser = false;

        for(User u : users) {
            if(u.getUsername().equals(username)) {
                isUser = true;
                break;
            }
        }

        return isUser;
    }

    // Sjekker om passord oppgitt er det samme som lagret
    public static boolean passwordMatch(String username, String password) {
        boolean match = false;

        for(User u : users) {
            if(u.getUsername().equals(username)) {
                if(u.getPassword().equals(password))
                match = true;
                break;
            }
        }

        if(!match) {
            System.out.println("MockDB: incorrect password");
        }

        return match;
    }

    public static void addUser(User user) {
        boolean userAdded = users.add(user);
        System.out.println("User("+ user.getUsername() + ") added: " + userAdded);
    }

    public static boolean isUsernameAvailable(String username) {

        boolean available = true;

            if(isUser(username)) {
                System.out.println("MockDB: username taken");
                available = false;
            }

        return available;
    }

    public static void addGame(Game game) {
        games.add(game);
    }

    public static Game getGame(int id) {
        for(Game g : games) {
            if(g.getId() == id) {
                return g;
            }
        }
        return null;
    }

}
