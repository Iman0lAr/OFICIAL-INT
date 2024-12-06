
package com.example.demo.Repositorio;

import com.example.demo.Entidades.Sexo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioSexo  extends JpaRepository<Sexo, Integer> {
    
}
