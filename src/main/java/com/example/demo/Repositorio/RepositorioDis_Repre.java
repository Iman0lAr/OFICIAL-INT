
package com.example.demo.Repositorio;

import com.example.demo.Entidades.Discapacitado_Representane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioDis_Repre extends JpaRepository<Discapacitado_Representane, Integer> {
    
         @Query(value = "SELECT  * from tb_dis_representante   where id_discapacitado=?1 AND id_representante=?2", nativeQuery = true)
    Discapacitado_Representane buscarPorDiscRepre (Integer idDiscapacitado ,Integer idRepresentante);
    
    
}
