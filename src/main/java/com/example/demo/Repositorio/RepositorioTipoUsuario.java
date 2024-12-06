
package com.example.demo.Repositorio;

import com.example.demo.Entidades.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioTipoUsuario extends JpaRepository<TipoUsuario, Integer> {
    
}
