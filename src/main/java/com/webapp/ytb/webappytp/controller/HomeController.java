package com.webapp.ytb.webappytp.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String redirectToAccueil() {
        return "redirect:/menu";
    }

    @GetMapping("/fiche")
    public String fiche(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        String username = userDetails.getUsername();
        String role = userDetails.getAuthorities().stream().findFirst().get().getAuthority();
        model.addAttribute("username", username);
        model.addAttribute("role", role);
        return "index";
    }

    @GetMapping("/admin")
    public String admin(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        String role = userDetails.getAuthorities().stream().findFirst().get().getAuthority();
        if ("ROLE_ADMIN".equals(role)) {
            return "admin";
        }
        return "redirect:/menu";
    }

    @GetMapping("/menu")
    public String menu(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        String username = userDetails.getUsername();
        String role = userDetails.getAuthorities().stream().findFirst().get().getAuthority();
        model.addAttribute("username", username);
        model.addAttribute("role", role);
        return "menu";
    }
}
