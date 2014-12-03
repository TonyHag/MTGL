package com.springapp.mvc.controller;

import com.springapp.mvc.model.Game;
import com.springapp.mvc.model.Player;
import com.springapp.mvc.service.MockDB;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

/**
 * Created by eirikskogland on 03.12.14.
 */
@Controller
@RequestMapping("/game")
public class GameController {

    @RequestMapping(value = "/{gameId}", method = RequestMethod.GET)
    public String getGame(@PathVariable("gameId") int gameId, ModelMap model) {

        // hent game info fra db
        Game game = MockDB.getGame(gameId);

        if(game != null) {

            model.addAttribute("game", game);


        } else {
            System.out.println("GameController: Game is null!");
            return "redirect:/mainMenu";
        }




        // gjør klar model

        return "game";

    }



}
