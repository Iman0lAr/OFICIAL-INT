
package com.example.demo.Repositorio;

import com.example.demo.Entidades.Provincia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioProvincia extends JpaRepository<Provincia, Integer>  {
    
}
