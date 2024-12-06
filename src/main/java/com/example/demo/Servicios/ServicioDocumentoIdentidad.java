
package com.example.demo.Servicios;

import com.example.demo.Entidades.DocumentoDeIdentidad;
import com.example.demo.Repositorio.RepositorioDocuementoIden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioDocumentoIdentidad {
    
    @Autowired
    private RepositorioDocuementoIden repositorioDocuementoIden;
    
    public DocumentoDeIdentidad buscarByNro(String nroDocumento){
        return repositorioDocuementoIden.buscarPorNro(nroDocumento);
    }
    
    
}
