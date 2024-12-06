/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Servicios;

import com.example.demo.Entidades.TipoRelacion;
import com.example.demo.Repositorio.RepositorioTipoRelacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioTipoRelacion {
    
    @Autowired
    private RepositorioTipoRelacion repositorioTipoRelacion;
    
    public List<TipoRelacion> findAll(){
        return  repositorioTipoRelacion.findAll();
    }
    
}
