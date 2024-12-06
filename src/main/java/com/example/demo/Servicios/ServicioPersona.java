
package com.example.demo.Servicios;

import com.example.demo.Entidades.Persona;
import com.example.demo.Entidades.Usuario;
import com.example.demo.Repositorio.RepositorioPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioPersona {
    
    @Autowired
    private RepositorioPersona repositorioPersona;
    
    public Persona guardar(Persona persona){
        return repositorioPersona.insertarPersona(
                persona.getNombre(),
                persona.getApell_paterno(), 
                persona.getApell_materno(), 
                persona.getDocumentoDeIdentidad().getNro_documento(),
                persona.getSexo().getNom_sexo());
    }
    
    public Persona buscarPorId(Integer id){
        return repositorioPersona.findById(id).orElse(null);
    }
    
    public Persona InsertarPersona_U(Persona persona){
        return repositorioPersona.insertarPersona_U(
                persona.getNombre(),
                persona.getApell_paterno(), 
                persona.getApell_materno(), 
                persona.getDocumentoDeIdentidad().getNro_documento(), 
                persona.getSexo().getNom_sexo());
    }
    
   public Persona buscarPorDocumentIdentidad(String nro){
       return repositorioPersona.buscarPorNroDocumento(nro);
   }
   
   
   public Persona insertarPersonaRepresentante(Persona personaRepre){
       return repositorioPersona.insertarPersonaRepresentantePc(
               personaRepre.getNombre(),
               personaRepre.getApell_paterno(), 
               personaRepre.getApell_materno(), 
               personaRepre.getDocumentoDeIdentidad().getNro_documento(), 
               personaRepre.getSexo().getNom_sexo());
   }
}
