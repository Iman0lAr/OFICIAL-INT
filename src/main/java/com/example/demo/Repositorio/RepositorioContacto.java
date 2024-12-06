
package com.example.demo.Repositorio;

import com.example.demo.Entidades.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioContacto extends JpaRepository<Contacto, Integer>  {
    
}
