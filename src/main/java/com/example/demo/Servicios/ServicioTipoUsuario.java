
package com.example.demo.Servicios;

import com.example.demo.Repositorio.RepositorioTipoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioTipoUsuario {
    
    @Autowired
    private RepositorioTipoUsuario repositorioTipoUsuario;
}
