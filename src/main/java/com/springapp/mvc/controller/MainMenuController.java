package com.springapp.mvc.controller;

import com.springapp.mvc.service.CookieService;
import com.springapp.mvc.service.ValidationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by eirikskogland on 03.12.14.
 */

@Controller
public class MainMenuController {

    @RequestMapping(value = "/mainMenu", method = RequestMethod.GET)
    public String getMainMenu(ModelMap model, HttpServletRequest request) {
        System.out.println("Getting menu page");
        String user = CookieService.getLoggedInUser(request);
        if(user != null) {
            model.addAttribute("user", user);

            return "mainMenu";
        }

        return "redirect:login";
    }


}
