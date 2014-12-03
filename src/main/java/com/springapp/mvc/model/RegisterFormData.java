package com.springapp.mvc.model;

import javax.validation.constraints.NotNull;

/**
 * Created by eirikskogland on 02.12.14.
 * Laget kun for å gjøre behandling av data fra registreringsskjema enklere før det opprettes en bruker
 * Brukes som @ModelAttribute i RegisterController
 */
public class RegisterFormData {


    // Annotasjoner for validering av input
    @NotNull
    private String username;

    @NotNull
    private String password1;

    @NotNull
    private String password2;

    @NotNull
    private String email;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
