package com.springapp.mvc.service;

/**
 * Created by eirikskogland on 02.12.14.
 */
public class ValidationService {


    public static boolean validateUsername(String username) {
        boolean valid = true;

        // Sjekk med regex


        // Sjekk med db
        if(!MockDB.isUsernameAvailable(username)) {
            valid = false;
        }
        return valid;
    }

    public static boolean validatePassword(String password) {

        // Sjekk med regex

        return true;
    }

    public static boolean validateEmail(String email) {

        // Sjekk med regex

        return true;

    }

}
