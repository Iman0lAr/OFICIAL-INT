
package com.example.demo.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_departamento")
public class Departamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_departamento;
    
    private String nom_departamento;

    public Departamento(Integer id_departamento, String nom_departamento) {
        this.id_departamento = id_departamento;
        this.nom_departamento = nom_departamento;
    }

    public Departamento() {
    }
    
    

    public Departamento(String nom_departamento) {
        this.nom_departamento = nom_departamento;
    }

    public Integer getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(Integer id_departamento) {
        this.id_departamento = id_departamento;
    }

    public String getNom_departamento() {
        return nom_departamento;
    }

    public void setNom_departamento(String nom_departamento) {
        this.nom_departamento = nom_departamento;
    }
    
    
}
