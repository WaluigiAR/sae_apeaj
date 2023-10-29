package com.webapp.ytb.webappytp.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String redirectToAccueil() {
        return "redirect:/accueil";
    }

    @RequestMapping(value = "/accueil", method = RequestMethod.GET)
    public String accueil(Model model) {
        // Récupérez le nom de l'utilisateur connecté
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof User) {
            String username = ((User) principal).getUsername();
            model.addAttribute("username", username);
        }
        return "index";
    }
}
