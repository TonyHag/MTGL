package com.springapp.mvc.controller;

import com.springapp.mvc.model.Game;
import com.springapp.mvc.model.Player;
import com.springapp.mvc.service.CookieService;
import com.springapp.mvc.service.IdService;
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

    ArrayList<String> invitedPlayerNames = new ArrayList<String>();
    ArrayList<Player> players = new ArrayList<Player>();
    String gameCreator = null;
    String invitePlayerError;
    boolean initialVisit = true;

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String getLobbyPage(ModelMap model, HttpServletRequest request) {
        System.out.println("Getting lobby page");

        if(true) { // hvis logget inn

            if(initialVisit) {
                gameCreator = CookieService.getLoggedInUser(request);
                model.addAttribute("gameCreator", gameCreator);
            }

            model.addAttribute("invitePlayerError", invitePlayerError);
            model.addAttribute("invitedPlayers", invitedPlayerNames);

            return "lobby";
        }

        return "redirect:login";

    }

    @RequestMapping(value = "/invite", method = RequestMethod.POST)
    public String invitePlayer(ModelMap model, @RequestParam(value="invitePlayer") String invitePlayer) {

        if(true) { // hvis logget inn

            // Sjekk at man ikke inviterer seg selv
            if(gameCreator != null && gameCreator.equals(invitePlayer)) {
                invitePlayerError = "Invite a friend!";
                return "redirect:main";
            }

            // Sjekk at man ikke inviterer samme flere ganger
            for(String name : invitedPlayerNames) {
                if(name.equals(invitePlayer)) {
                    invitePlayerError = "Player already invited";
                    return "redirect:main";
                }
            }

            // Sjekk at spiller eksisterer
            if(MockDB.isUser(invitePlayer)) {

                invitePlayerError = "";
                invitedPlayerNames.add(invitePlayer);
                return "redirect:main";

            } else {

                invitePlayerError = "Player not found";
                return "redirect:main";

            }
        }

        return "redirect:login";
    }

    @RequestMapping(value ="/startGame", method = RequestMethod.GET)
    public String startGame(ModelMap model) {

        if(true) { // hvis logget inn
            // Opprett nytt game
            Game game = new Game();

            Player host = new Player();
            host.setUsername(gameCreator);
            host.setHp(20);
            players.add(host);

            for(String username : invitedPlayerNames) {
                Player p = new Player();
                p.setHp(20);
                p.setUsername(username);
                players.add(p);
            }

            int gameId = IdService.getGameId();
            game.setPlayers(players);
            game.setId(gameId);
            MockDB.addGame(game);

            return ("redirect:/game/" + gameId);
        }

        return "redirect:login";

    }

}
