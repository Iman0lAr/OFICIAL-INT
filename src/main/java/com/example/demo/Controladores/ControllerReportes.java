
package com.example.demo.Controladores;

import com.example.demo.Entidades.Usuario;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerReportes {
    
    @GetMapping("/Reportes")
    public String mostrarVista(HttpSession sesion){
        if(sesion.getAttribute("uss")==null){
            return "redirect:/index";
        }
        
        Usuario uss=(Usuario) sesion.getAttribute("uss");
        if(uss.getTipoUsuario().getId_tipo_usuario()!=1){
            return "redirect:/home";
        }
        
        return "Reportes";
    }
    
}
