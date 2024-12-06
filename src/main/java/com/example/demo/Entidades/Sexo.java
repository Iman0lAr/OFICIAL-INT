
package com.example.demo.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_sexo")
public class Sexo {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_sexo; 
    private String nom_sexo;

    public Sexo(Integer id_sexo, String nom_sexo) {
        this.id_sexo = id_sexo;
        this.nom_sexo = nom_sexo;
    }

    public Sexo(String nom_sexo) {
        this.nom_sexo = nom_sexo;
    }

    public Sexo() {
    }

    public Integer getId_sexo() {
        return id_sexo;
    }

    public void setId_sexo(Integer id_sexo) {
        this.id_sexo = id_sexo;
    }

    public String getNom_sexo() {
        return nom_sexo;
    }

    public void setNom_sexo(String nom_sexo) {
        this.nom_sexo = nom_sexo;
    }
    
    
}
