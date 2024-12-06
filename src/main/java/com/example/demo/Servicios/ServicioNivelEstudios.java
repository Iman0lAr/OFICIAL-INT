
package com.example.demo.Servicios;

import com.example.demo.Entidades.NivelEstudio;
import com.example.demo.Repositorio.RepositorioNicelEstudios;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioNivelEstudios {
    
    @Autowired
    private RepositorioNicelEstudios repositorioNicelEstudios;
    
    
    
    public List<NivelEstudio> findAll(){
        return repositorioNicelEstudios.findAll();
    }
    
}
