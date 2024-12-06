
package com.example.demo.Servicios;

import com.example.demo.Entidades.Departamento;
import com.example.demo.Repositorio.RepositorioDepartamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioDepartamento {
    
    @Autowired
    private RepositorioDepartamento repositorioDepartamento;
    
     public Departamento guardar(Departamento departamento){
        return repositorioDepartamento.save(departamento);
    }
}
