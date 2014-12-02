package com.springapp.mvc.controller;

import com.springapp.mvc.model.RegisterFormData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public String submitRegisterForm(ModelMap model, @ModelAttribute RegisterFormData data) {


        // RegisterFromData data blir laget automatisk siden attributtene i RegisterFormData har samme navn som i formen
        String username = data.getUsername();
        String password1 = data.getPassword1();
        String password2 = data.getPassword2();
        String email = data.getEmail();



        // valider parametre, metachars, lengde, osv

        // sjekk om brukernavn ledig

            // ledig
                // krypter passord
                // generer unik id
                // opprett bruker
                // lagre i database
                // returner til login

            // ikke ledig
                // returner til register med feilmelding


        return "register";
    }


}
