
package com.example.demo.Repositorio;

import com.example.demo.Entidades.TipoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioTipoDocu extends JpaRepository<TipoDocumento, Integer> {
    
}
