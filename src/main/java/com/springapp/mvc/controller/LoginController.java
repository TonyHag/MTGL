package com.springapp.mvc.controller;

import com.javafx.tools.doclets.formats.html.SourceToHTMLConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by eirikskogland on 02.12.14.
 */

@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping(method = RequestMethod.GET)
    public String getLoginForm(ModelMap model) {
        System.out.println("Getting login page");
        return "login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submitLoginForm(ModelMap model) {
        System.out.println("Login form submitted");
        return "login";
    }
}
