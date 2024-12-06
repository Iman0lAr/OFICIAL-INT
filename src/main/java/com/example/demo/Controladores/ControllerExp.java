
package com.example.demo.Controladores;

import com.example.demo.Entidades.Discapacitado;
import com.example.demo.Entidades.Representante;
import com.example.demo.Servicios.ServicioDiscapacitado;
import com.example.demo.Servicios.ServicioRepresentante;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ControllerExp {
    
    @Autowired
    private ServicioDiscapacitado serv;
    
    @Autowired
    private ServicioRepresentante servR;
    
    @GetMapping("/actualizarFotos")
    public String mostrarVista(){
        return "actualizarFoto";
    }
    
    @PostMapping("/Actua")
    public String actualizar(@RequestParam(value = "newFoto", required = true) MultipartFile file5) throws IOException{
        Representante repre=new Representante();
        repre.setId_representante(2);
        repre.setCopia_dni(obtenerImagen(file5));
        
        Representante r= servR.actualizar(repre);

        return "redirect:/actualizarFotos";
    }
    
    
    
    
    
      private byte[] obtenerImagen(MultipartFile file) throws IOException {
        if (file == null || file.isEmpty()) {
            return null;
        }
        return file.getBytes();
    }
}
