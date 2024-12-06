
package com.example.demo.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_ciudad")
public class Provincia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_ciudad ;
    private String nom_ciudad ;
    
    @JoinColumn(name =" id_departamento")
    @ManyToOne
    private Departamento departamento;

    public Provincia(Integer id_ciudad, String nom_ciudad, Departamento departamento) {
        this.id_ciudad = id_ciudad;
        this.nom_ciudad = nom_ciudad;
        this.departamento = departamento;
    }

    public Provincia(String nom_ciudad, Departamento departamento) {
        this.nom_ciudad = nom_ciudad;
        this.departamento = departamento;
    }

    public Provincia() {
    }

    public Integer getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(Integer id_ciudad) {
        this.id_ciudad = id_ciudad;
    }

    public String getNom_ciudad() {
        return nom_ciudad;
    }

    public void setNom_ciudad(String nom_ciudad) {
        this.nom_ciudad = nom_ciudad;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
    
    
    
}
