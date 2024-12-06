
package com.example.demo.Repositorio;

import com.example.demo.Entidades.Tramite;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioTramite extends JpaRepository<Tramite, Integer> {
    
         @Query(value = "CALL usp_Insert_tramite(:new_id_Info_Discapacitado,:tramite_tipo,:id_usuario,:new_correo,:new_tel_fijo,:new_img_solicitud)", nativeQuery = true)
    Tramite insertarTramite(
            @Param("new_id_Info_Discapacitado") Integer new_id_Info_Discapacitado,
            @Param("tramite_tipo") String tramite_tipo,
            @Param("id_usuario") Integer id_usuario,
            @Param("new_correo") String new_correo,
            @Param("new_tel_fijo") String new_tel_fijo,
            @Param("new_img_solicitud") byte[] new_img_solicitud);
    
    
     @Query(value = "CALL usp_obtener_Tramite_Hoy()", nativeQuery = true)
    List<Tramite> obtenerTramitesHoy();
 
      @Query(value = "CALL usp_Insert_tramitePC(:new_id_Info_Discapacitado,:codigo_tramite_tipo,:id_usuario)", nativeQuery = true)
    Tramite insertarTramitePC(
            @Param("new_id_Info_Discapacitado") Integer new_id_Info_Discapacitado,
            @Param("codigo_tramite_tipo") Integer codigo_tramite_tipo,
            @Param("id_usuario") Integer id_usuario);
   
}
