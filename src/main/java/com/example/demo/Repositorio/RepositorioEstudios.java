
package com.example.demo.Repositorio;

import com.example.demo.Entidades.Estudios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioEstudios extends JpaRepository<Estudios, Integer> {
    
}
