
package com.example.demo.Repositorio;

import com.example.demo.Entidades.TipoRelacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioTipoRelacion extends JpaRepository<TipoRelacion, Integer>  {
    
}
