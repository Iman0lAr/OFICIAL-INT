
package com.example.demo.Repositorio;

import com.example.demo.Entidades.CertificadoDeDiscapacidad;
import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioCertificadoDeDiscapacidad extends JpaRepository<CertificadoDeDiscapacidad, Integer> {
    
         @Query(value = "CALL usp_Insertar_CertificadoDiscapacidad(:new_fecha_emision,:new_num_certificado,:new_id_discapacitado,:new_copia_par1,:new_copia_par2)", nativeQuery = true)
    CertificadoDeDiscapacidad insertarCertificadoDeDiscapacidad(
            @Param("new_fecha_emision") LocalDate new_fecha_emision,
            @Param("new_num_certificado") String new_num_certificado,
            @Param("new_id_discapacitado") Integer new_id_discapacitado,
            @Param("new_copia_par1") byte [] new_copia_par1,
            @Param("new_copia_par2") byte[] new_copia_par2);
    
    @Query(value = "CALL usp_Obtener_Info_Discapacitado(:codigo_Certificado_Dis)", nativeQuery = true)
    CertificadoDeDiscapacidad obtenerCer_Dis_Perso(
            @Param("codigo_Certificado_Dis") Integer codigo_Certificado_Dis);
}
