package com.springapp.mvc.service;

import com.springapp.mvc.model.User;

import java.util.ArrayList;

/**
 * Created by eirikskogland on 02.12.14.
 * Gidder ikke sette opp ekte database, så det får holde med en mock med samme funksjonalitet,
 * så blir det enkelt å sette opp en ekte utifra denne.
 */
public class MockDB {
    private static ArrayList<User> users = new ArrayList<User>();



    public static void addUser(User user) {
        boolean userAdded = users.add(user);
        System.out.println("User("+ user.getUsername() + ") added: " + userAdded);
    }

    public static boolean isUsernameAvailable(String username) {
        for(User u : users) {
            if(u.getUsername().equals(username)) {
                System.out.println("Username taken");
                return false;
            }
        }
        return true;
    }
}
