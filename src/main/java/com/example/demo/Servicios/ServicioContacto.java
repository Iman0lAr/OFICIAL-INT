
package com.example.demo.Servicios;

import com.example.demo.Entidades.Contacto;
import com.example.demo.Repositorio.RepositorioContacto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioContacto {
    
    @Autowired
    private RepositorioContacto repositorioContacto;
    
     public Contacto guardar(Contacto contacto){
        return repositorioContacto.save(contacto);
    }
     
     
}
