
package com.example.demo.Repositorio;

import com.example.demo.Entidades.Infor_Discapacitado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioInfo_Discapacitado extends JpaRepository<Infor_Discapacitado, Integer>  {
    
    
      @Query(value = "CALL usp_Insertr_Info_Disca(:new_id_discapacitado,:new_id_certificado,:new_id_direccion,:new_id_representante,:new_id_Direccion_Repre)", nativeQuery = true)
    Infor_Discapacitado insertarInfor_Discapacitado(
            @Param("new_id_discapacitado") Integer new_id_discapacitado,
            @Param("new_id_certificado") Integer new_id_certificado,
            @Param("new_id_direccion") Integer new_id_direccion,
            @Param("new_id_representante") Integer new_id_representante,
            @Param("new_id_Direccion_Repre") Integer new_id_Direccion_Repre);
    
}
