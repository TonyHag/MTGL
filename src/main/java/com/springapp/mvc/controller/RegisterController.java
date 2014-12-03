package com.springapp.mvc.controller;

import com.springapp.mvc.model.RegisterFormData;
import com.springapp.mvc.model.User;
import com.springapp.mvc.service.MockDB;
import com.springapp.mvc.service.ValidationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sun.plugin2.message.Message;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by eirikskogland on 02.12.14.
 */
@Controller
@RequestMapping("/register")
public class RegisterController {

    @RequestMapping(method = RequestMethod.GET)
    public String getRegisterForm(ModelMap model) {
        System.out.println("Getting register page");
        return "register";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submitRegisterForm(ModelMap model, @ModelAttribute RegisterFormData data) {
        System.out.println("Registerform submitted");

        String returnJsp = "register";

        // RegisterFromData data blir laget automatisk siden attributtene i RegisterFormData har samme navn som i formen
        String username = data.getUsername();
        String password1 = data.getPassword1();
        String password2 = data.getPassword2();
        String email = data.getEmail();

        System.out.println("Entered:" );
        System.out.println("Username: " + username);
        System.out.println("Password: " + password1 + ", " + password2);
        System.out.println("email: " + email);
        boolean validInput = true;

        // valider brukernavn
        if(ValidationService.validateUsername(username)) {
            System.out.println("Username valid");
        } else {
            validInput = false;
        }

        // Valider passord
        if(ValidationService.validatePassword(password1) && password1.equals(password2)) {
            System.out.println("Password valid");
        } else {
            validInput = false;
        }

        // Valider email
        if(ValidationService.validateEmail(email)) {
            System.out.println("email valid");
        } else {
            validInput = false;
        }

        if(validInput) {

            // krypter passord

            StringBuffer PasswordHexString = null;
            try {

                MessageDigest digest = MessageDigest.getInstance("SHA-256");
                String salt = "hemmeligsalt";

                byte[] hash = digest.digest((password1+salt).getBytes("UTF-8"));

                // Konteverterer fra byte[] til hex-streng
                PasswordHexString = new StringBuffer();
                for (int i = 0; i < hash.length; i++) {
                    String hex = Integer.toHexString(0xff & hash[i]);
                    if(hex.length() == 1) PasswordHexString.append('0');
                    PasswordHexString.append(hex);
                }

                // Opprett ny bruker
                User newUser = new User(username, password1, email);

                // generer unik id
                int id = 0;
                newUser.setId(id);

                // lagre i database
                MockDB.addUser(newUser);
                // returner til login
                returnJsp = "redirect:login";

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return returnJsp;
    }


}
