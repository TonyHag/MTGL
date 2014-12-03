package com.springapp.mvc.controller;

import com.springapp.mvc.service.CookieService;
import com.springapp.mvc.service.MockDB;
import com.springapp.mvc.service.ValidationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * Created by eirikskogland on 03.12.14.
 */
@Controller
@RequestMapping("/lobby")
public class LobbyController {

    ArrayList<String> invitedPlayers = new ArrayList<String>();

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String getLoginForm(ModelMap model, HttpServletRequest request) {
        System.out.println("Getting lobby page");
        String user = CookieService.getLoggedInUser(request);
        if(user != null) {
            model.addAttribute("user", user);

            //model.addAttribute("invitedPlayers", invitedPlayers);

            return "lobby";
        }
        return "redirect:login";
    }

    @RequestMapping(value = "/invite", method = RequestMethod.POST)
    public String invitePlayer(ModelMap model, @RequestParam(value="invitePlayer") String invitePlayer) {
        if(MockDB.isUser(invitePlayer)) {

            System.out.println("LobbyController: User found, adding to invited players");

            invitedPlayers.add(invitePlayer);

            return "redirect:main";
        }

        System.out.println("LobbyController: User not found");

        return "redirect:main";
    }

    @RequestMapping(value ="/startGame", method = RequestMethod.GET)
    public String startGame(ModelMap model) {

       // Opprett nytt game

       // Gå til GameController med game id

       return "redirect:main";
    }

}
