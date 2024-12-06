package com.example.demo.Controladores;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerIndex {

    @GetMapping("/index")
    String mostrarLogin(Model model, HttpSession session) {
        if (session.getAttribute("uss") != null) {
            return "redirect:/home";
        }
        model.addAttribute("error", false);
        return "index";
    }
}
