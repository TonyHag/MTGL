package com.springapp.mvc.controller;

import com.javafx.tools.doclets.formats.html.SourceToHTMLConverter;
import com.springapp.mvc.service.ValidationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by eirikskogland on 02.12.14.
 */

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginForm(ModelMap model) {
        System.out.println("Getting login page");
        return "login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submitLoginForm(ModelMap model, HttpServletResponse response, @RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        System.out.println("Login form submitted");
        String returnJsp = "login";

        if(ValidationService.validateLogin(username, password)) {
            System.out.println("LoginController: Login success!");

            // Opprett ny session id + andre ting som må gjøres ved login
            Cookie usernameCookie = new Cookie("username", username);
            response.addCookie(usernameCookie);

            returnJsp = "redirect:mainMenu";
        } else {
            System.out.println("LoginController: Login failed!");

        }

        return returnJsp;
    }

}
