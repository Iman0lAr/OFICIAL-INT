
package com.example.demo.Repositorio;

import com.example.demo.Entidades.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioDepartamento extends JpaRepository<Departamento, Integer>  {
    
}
