package com.example.demo.Servicios;

import com.example.demo.Entidades.Direccion;
import com.example.demo.Entidades.Discapacitado;
import com.example.demo.Repositorio.RepositorioDiscapacitado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioDiscapacitado {

    @Autowired
    private RepositorioDiscapacitado repositorioDiscapacitado;

    public Discapacitado guardar(Direccion direccion,byte[] copia_dni) {
        try {
          return  repositorioDiscapacitado.insertarDiscapacitado(
                    direccion.getPersona().getId_persona(),
                    copia_dni);
        } catch (Exception e) {
            e.printStackTrace(); // O usa un logger para registrar el error
        }
        return  null;
    }
    
     public Discapacitado buscarId(Integer id){
        return repositorioDiscapacitado.findById(id).orElse(null);
    }
     
     public Discapacitado acutualizar(Discapacitado disc){
        return repositorioDiscapacitado.save(disc);
     }
     
     
     public Discapacitado buscarPorIdPersona(Integer id){
         return repositorioDiscapacitado.buscarPorPersona(id);
     }
     public Discapacitado insertDiscPc(Integer idPersona, Discapacitado discapacitado,String descEstudio,Integer nivelEstudio){
         return repositorioDiscapacitado.insertarDiscapacitadoTC(
                 idPersona,
                 discapacitado.getCom_indigena(), 
                 discapacitado.getLen_originaria(), 
                 discapacitado.getAutopercepcion(), 
                 discapacitado.getMani_voluntad(), 
                 discapacitado.getDifi_ir_banco(),
                 discapacitado.getFecha_Nac(), 
                 discapacitado.getTel_fijo(), 
                 discapacitado.getCelular(),
                 discapacitado.getCorreo(), 
                 descEstudio, 
                 nivelEstudio);
     }
   
}
