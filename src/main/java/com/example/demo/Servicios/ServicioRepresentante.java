
package com.example.demo.Servicios;

import com.example.demo.Entidades.Representante;
import com.example.demo.Repositorio.RepositorioRepresentante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioRepresentante {
    
    @Autowired
    private RepositorioRepresentante repositorioRepresentante;
    
    public Representante guardar(Integer id_repre,Integer id_disca,byte[] copia_dni) {
        try {
          if(id_repre!=null){
          return  repositorioRepresentante.insertarRepresentante(
                    id_repre,
                    id_disca,
                    copia_dni);
            }
        } catch (Exception e) {
            e.printStackTrace(); // O usa un logger para registrar el error
        }
        return  null;
    }
    //(condicion) ? valorSiEsVerdadero : valorSiEsFalso;
     public Representante buscarId(Integer id){
        return repositorioRepresentante.findById(id).orElse(null);
    }
     
     public Representante obtenerRepresentante(Integer id){
     
        return repositorioRepresentante.obtenerRepre(id);
     }
     public Representante actualizar(Representante representante){
         return repositorioRepresentante.save(representante);
     }
     
     public Representante insertarRepresentantePc(Representante representante,Integer idPersona,Integer idDissc,Integer idTipoRela){
         return repositorioRepresentante.insertarRepresentantePc(idPersona, representante.getTel_fijo(), representante.getCorreo(), idDissc, idTipoRela);
     }
}
