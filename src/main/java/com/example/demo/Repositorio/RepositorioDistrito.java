
package com.example.demo.Repositorio;

import com.example.demo.Entidades.Distrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioDistrito extends JpaRepository<Distrito, Integer>  {
    
}
