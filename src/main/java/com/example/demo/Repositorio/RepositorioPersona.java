
package com.example.demo.Repositorio;

import com.example.demo.Entidades.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioPersona extends JpaRepository<Persona, Integer> {
    
    @Query(value = "CALL usp_Insertar_Persona(:nombre,:apellido_pat,:apellido_mat,:nro_documento,:sexo)", nativeQuery = true)
    Persona insertarPersona(
            @Param("nombre") String nombre,
            @Param("apellido_pat") String apellido_pat,
            @Param("apellido_mat") String apellido_mat,
            @Param("nro_documento") String nro_documento,
            @Param("sexo") String sexo);
    
    
     @Query(value = "CALL usp_insertar_PersonaU(:new_nombre,:new_apell_paterno,:new_apell_materno,:dni,:sexo)", nativeQuery = true)
    Persona insertarPersona_U(
            @Param("new_nombre") String new_nombre,
            @Param("new_apell_paterno") String new_apell_paterno,
            @Param("new_apell_materno") String new_apell_materno,
            @Param("dni") String dni,
            @Param("sexo") String sexo);
    
    @Query(value = " SELECT tp.* FROM  tb_persona tp inner join tb_documento_identidad tdi  on tp.id_documento =tdi.id_documento WHERE  tdi.nro_documento =?1", nativeQuery = true)
    Persona buscarPorNroDocumento(
            String nroDocumento
            );
    
            
      
    @Query(value = "CALL usp_Insertar_PersonaRepresentantePC(:new_nombre,:new_apell_paterno,:new_apell_materno,:new_nro_documento,:new_nom_sexo)", nativeQuery = true)
    Persona insertarPersonaRepresentantePc(
            @Param("new_nombre") String nombre,
            @Param("new_apell_paterno") String apellido_pat,
            @Param("new_apell_materno") String apellido_mat,
            @Param("new_nro_documento") String nro_documento,
            @Param("new_nom_sexo") String sexo);
            
            
}
