package com.example.demo.Repositorio;

import com.example.demo.Entidades.Direccion;
import com.example.demo.Entidades.Discapacitado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioDireccion extends JpaRepository<Direccion, Integer> {

    @Query(value = "CALL usp_Insertar_Persona(:new_nombre,:new_apell_paterno,:new_apell_materno,:new_nro_documento,:new_nom_sexo,:distrito,:Provincia,:Departamento,:new_calle)", nativeQuery = true)
    Direccion insertar(
            @Param("new_nombre") String new_nombre,
            @Param("new_apell_paterno") String new_apell_paterno,
            @Param("new_apell_materno") String new_apell_materno,
            @Param("new_nro_documento") String new_nro_documento,
            @Param("new_nom_sexo") String new_nom_sexo,
            @Param("distrito") String distrito,
            @Param("Provincia") String Provincia,
            @Param("Departamento") String Departamento,
            @Param("new_calle") String new_calle);

    @Query(value = "CALL usp_Insertar_PersonaPC(:new_nombre,:new_apell_paterno,:new_apell_materno,:new_nro_documento,:new_nom_sexo,:distrito,:Provincia,:Departamento,:new_calle,:new_ref,:new_CentroP)", nativeQuery = true)
    Direccion insertarPC(
            @Param("new_nombre") String new_nombre,
            @Param("new_apell_paterno") String new_apell_paterno,
            @Param("new_apell_materno") String new_apell_materno,
            @Param("new_nro_documento") String new_nro_documento,
            @Param("new_nom_sexo") String new_nom_sexo,
            @Param("distrito") String distrito,
            @Param("Provincia") String Provincia,
            @Param("Departamento") String Departamento,
            @Param("new_calle") String new_calle,
            @Param("new_ref") String new_ref,
            @Param("new_CentroP") String new_CentroP);
    
   
   
}
