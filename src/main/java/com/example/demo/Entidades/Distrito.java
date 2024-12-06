
package com.example.demo.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_distrito")
public class Distrito {
    
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_distrito ;
    private String nom_distrito ;
    
    @JoinColumn(name =" id_ciudad")
    @ManyToOne
    private Provincia provincia;

    public Distrito(Integer id_distrito, String nom_distrito, Provincia provincia) {
        this.id_distrito = id_distrito;
        this.nom_distrito = nom_distrito;
        this.provincia = provincia;
    }

    public Distrito(String nom_distrito, Provincia provincia) {
        this.nom_distrito = nom_distrito;
        this.provincia = provincia;
    }

    public Distrito() {
    }

    public Integer getId_distrito() {
        return id_distrito;
    }

    public void setId_distrito(Integer id_distrito) {
        this.id_distrito = id_distrito;
    }

    public String getNom_distrito() {
        return nom_distrito;
    }

    public void setNom_distrito(String nom_distrito) {
        this.nom_distrito = nom_distrito;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }
    
    
    
}
