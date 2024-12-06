
package com.example.demo.Controladores;

import com.example.demo.Entidades.Tramite;
import com.example.demo.Servicios.ServicioTramite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ControllerGesionarTramites {
    
    @Autowired
    private ServicioTramite servicioTramite;
    
    @GetMapping("/gestionarTramite/{id}")
    public String redireccionar(
           @PathVariable("id") Integer id
    ){
        try{
            Tramite tramite = servicioTramite.buscarId(id);
            if(tramite.getTipoTramite().getId_tipo_tramite()==1){
                return "redirect:/gestionarTramiteCarnet/"+id;
            }
            
            if(tramite.getTipoTramite().getId_tipo_tramite()==2){
                return "redirect:/modificarTramiteProgramaContigo/"+id;
            }
        }catch(Exception e){
        }
        return "";
    }
    
}
