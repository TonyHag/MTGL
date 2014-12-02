package com.springapp.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by eirikskogland on 02.12.14.
 */
@Controller
@RequestMapping("/register")
public class RegisterController {

    @RequestMapping(method = RequestMethod.GET)
    public String getRegisterForm(ModelMap model) {

        return "register";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submitRegisterForm(ModelMap model) {

        // hent parametre

        // valider parametre, metachars, lengde, osv

        // sjekk om brukernavn ledig

            // ledig
                // opprett bruker
                // lagre i database
                // returner til login

            // ikke ledig
                // returner til register med feilmelding


        return "register";
    }


}
