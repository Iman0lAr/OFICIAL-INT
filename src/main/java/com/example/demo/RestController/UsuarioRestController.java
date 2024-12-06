

package com.example.demo.RestController;

import com.example.demo.Entidades.Usuario;
import com.example.demo.Servicios.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioRestController {
    
    @Autowired
    private ServicioUsuario servicioUsuario;
    
    @GetMapping("/usuario/{username}")
    public Usuario buscar(@PathVariable("username") String username){
        return servicioUsuario.buscarPorUsername(username);
    }
    
}
