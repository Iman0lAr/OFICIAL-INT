
package com.example.demo.Servicios;

import com.example.demo.Entidades.Infor_Discapacitado;
import com.example.demo.Repositorio.RepositorioInfo_Discapacitado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioInfoDiscapacitado {
    
     @Autowired
    private RepositorioInfo_Discapacitado repositorioInfo_Discapacitado;
    
    public Infor_Discapacitado guardar(Infor_Discapacitado infor_Discapacitado,boolean conf) {
        try {
          return  repositorioInfo_Discapacitado.insertarInfor_Discapacitado(
                   infor_Discapacitado.getDiscapacitado().getId_discapacitado(), 
                  infor_Discapacitado.getCertificadoDeDiscapacidad().getId_certificado(), 
                  infor_Discapacitado.getDireccion().getId_direccion(), 
                  (!conf)? infor_Discapacitado.getRepresentante().getId_representante():null,
                  (!conf)? infor_Discapacitado.getDireccion_repre().getId_direccion():null);
                    //infor_Discapacitado.getRepresentante().getId_representante()
        } catch (Exception e) {
            e.printStackTrace(); // O usa un logger para registrar el error
        }
        return  null;
    }
    
    
    public Infor_Discapacitado guardarInfoPc(Infor_Discapacitado infor_Discapacitado,boolean conf) {
        try {
          return  repositorioInfo_Discapacitado.insertarInfor_Discapacitado(
                   infor_Discapacitado.getDiscapacitado().getId_discapacitado(), 
                  infor_Discapacitado.getCertificadoDeDiscapacidad().getId_certificado(), 
                  infor_Discapacitado.getDireccion().getId_direccion(), 
                  (infor_Discapacitado.getRepresentante()==null)? null:infor_Discapacitado.getRepresentante().getId_representante(),
                  (!conf)? infor_Discapacitado.getDireccion_repre().getId_direccion():null);
                    //infor_Discapacitado.getRepresentante().getId_representante()
        } catch (Exception e) {
            e.printStackTrace(); // O usa un logger para registrar el error
        }
        return  null;
    }
    
    
    public Infor_Discapacitado buscar(Integer id){
        return repositorioInfo_Discapacitado.findById(id).orElse(null);
    }
    
    public Infor_Discapacitado modificar(Infor_Discapacitado info){
        return repositorioInfo_Discapacitado.save(info);
    }
}
