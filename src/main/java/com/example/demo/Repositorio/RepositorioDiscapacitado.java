
package com.example.demo.Repositorio;

import com.example.demo.Entidades.Discapacitado;
import java.time.LocalDate;
import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioDiscapacitado extends JpaRepository<Discapacitado, Integer>  {
    
@Query(value = "CALL usp_Insertar_Discapacitado(:new_id_Persona, :new_copia_dni)", nativeQuery = true)
Discapacitado insertarDiscapacitado(
        @Param("new_id_Persona") Integer new_id_Persona,
        @Param("new_copia_dni") byte[] new_copia_dni);

    
@Query(value = "SELECT * FROM tb_discapacitado td where id_persona =?", nativeQuery = true)
Discapacitado buscarPorPersona( Integer new_id_Persona);
  
    
@Query(value = "CALL usp_insertarDiscapacitado_PC(:new_id_Persona, :new_com_indigena,:new_len_originaria,:new_autopercepcion,:new_mani_voluntad,:new_difi_ir_banco,:new_fecha_Nac,:new_tel_fijo,:new_celular,:new_correo,:new_desc_estudios,:new_id_nivel)", nativeQuery = true)
Discapacitado insertarDiscapacitadoTC(
        @Param("new_id_Persona") Integer new_id_Persona,
        @Param("new_com_indigena") String new_com_indigena,
        @Param("new_len_originaria") String new_len_originaria,
        @Param("new_autopercepcion") String new_autopercepcion,
        @Param("new_mani_voluntad") Boolean new_mani_voluntad,
        @Param("new_difi_ir_banco") Boolean new_difi_ir_banco,
        @Param("new_fecha_Nac") LocalDate new_fecha_Nac,
        @Param("new_tel_fijo") String new_tel_fijo,
        @Param("new_celular") String new_celular,
        @Param("new_correo") String new_correo,
        @Param("new_desc_estudios") String new_desc_estudios,
        @Param("new_id_nivel") Integer new_id_nivel);

}
