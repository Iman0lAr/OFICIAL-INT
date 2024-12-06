package com.example.demo.Servicios;

import com.example.demo.Entidades.Tramite;
import com.example.demo.Repositorio.RepositorioTramite;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioTramite {

    @Autowired
    private RepositorioTramite repositorioTramite;

    public Tramite guardar(Tramite tramite) {
        try {
            return repositorioTramite.insertarTramite(
                    tramite.getInfor_Discapacitado().getId_info(),
                    tramite.getTipoTramite().getNom_tipo_tramite(),
                    tramite.getUsuario().getId_Usuario(),
                    tramite.getContacto().getCorreo(),
                    tramite.getContacto().getCelular(),
                    tramite.getImg_solicitud()
            );

        } catch (Exception e) {
            e.printStackTrace(); // O usa un logger para registrar el error
        }
        return null;
    }
    
     public Tramite buscarId(Integer id){
        return repositorioTramite.findById(id).orElse(null);
    }
     
    public List<Tramite> obtenerTramites(){
        return repositorioTramite.obtenerTramitesHoy();
    } 
    
    public Tramite modificar(Tramite tramite){
        return repositorioTramite.save(tramite);
    }
    
    public Tramite guardarTramitePC(Tramite tramite){
        return repositorioTramite.insertarTramitePC(tramite.getInfor_Discapacitado().getId_info(), tramite.getTipoTramite().getId_tipo_tramite(), tramite.getUsuario().getId_Usuario());
    }
}
