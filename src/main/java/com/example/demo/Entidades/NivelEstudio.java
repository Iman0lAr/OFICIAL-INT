
package com.example.demo.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_nivel_estudio")
public class NivelEstudio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_nivel;
    private String nom_nivel;

    public NivelEstudio(Integer id_nivel, String nom_nivel) {
        this.id_nivel = id_nivel;
        this.nom_nivel = nom_nivel;
    }

    public NivelEstudio() {
    }

    
    
    public NivelEstudio(String nom_nivel) {
        this.nom_nivel = nom_nivel;
    }

    public Integer getId_nivel() {
        return id_nivel;
    }

    public void setId_nivel(Integer id_nivel) {
        this.id_nivel = id_nivel;
    }

    public String getNom_nivel() {
        return nom_nivel;
    }

    public void setNom_nivel(String nom_nivel) {
        this.nom_nivel = nom_nivel;
    }
    
    
}
