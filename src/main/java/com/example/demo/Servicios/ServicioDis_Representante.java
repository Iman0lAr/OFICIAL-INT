
package com.example.demo.Servicios;

import com.example.demo.Entidades.Discapacitado_Representane;
import com.example.demo.Repositorio.RepositorioDis_Repre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioDis_Representante {
    
    @Autowired
    private RepositorioDis_Repre repositorioDis_Repre;
    
    public Discapacitado_Representane buscarPorDiscRepre(Integer idDiscapacitado,Integer idRepresentanInteger){
    
        return repositorioDis_Repre.buscarPorDiscRepre(idDiscapacitado, idRepresentanInteger);
    }
    
    
}
