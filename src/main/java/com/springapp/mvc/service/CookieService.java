package com.springapp.mvc.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by eirikskogland on 03.12.14.
 */
public class CookieService {

    // returnerer null om bruker ikke er logget inn
    public static String getLoggedInUser(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for(Cookie c : cookies) {
            if(c.getName().equals("username")) {
                System.out.println("CookieService: user cookie exists");
                return c.getValue();
            }
        }

        System.out.println("CookieService: User not logged in");
        return null;
    }




}
