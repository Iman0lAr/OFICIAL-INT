
package com.example.demo.Controladores;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerCerrar {
        
    @GetMapping("/Cerrar")
    public String cerrarSesion(HttpSession session){
        session.invalidate();
        return "redirect:/index";
    }
    
}
