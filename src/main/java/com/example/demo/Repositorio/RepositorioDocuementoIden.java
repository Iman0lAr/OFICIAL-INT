
package com.example.demo.Repositorio;

import com.example.demo.Entidades.DocumentoDeIdentidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioDocuementoIden extends JpaRepository<DocumentoDeIdentidad, Integer>  {
    
    @Query(value =  "select * from tb_documento_identidad WHERE  nro_documento =?1",nativeQuery = true)
    DocumentoDeIdentidad buscarPorNro(String nroDocumento);
    
}
