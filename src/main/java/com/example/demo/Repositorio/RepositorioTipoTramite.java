
package com.example.demo.Repositorio;

import com.example.demo.Entidades.TipoTramite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioTipoTramite extends JpaRepository<TipoTramite, Integer>  {
    
}
