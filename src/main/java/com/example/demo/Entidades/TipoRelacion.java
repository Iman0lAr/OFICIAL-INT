
package com.example.demo.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_tipo_relacion")
public class TipoRelacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_tipo_relacion;
    private String nom_tipo_relacion;

    public TipoRelacion(Integer id_tipo_relacion, String nom_tipo_relacion) {
        this.id_tipo_relacion = id_tipo_relacion;
        this.nom_tipo_relacion = nom_tipo_relacion;
    }

    public TipoRelacion(String nom_tipo_relacion) {
        this.nom_tipo_relacion = nom_tipo_relacion;
    }

    public TipoRelacion() {
    }

    public Integer getId_tipo_relacion() {
        return id_tipo_relacion;
    }

    public void setId_tipo_relacion(Integer id_tipo_relacion) {
        this.id_tipo_relacion = id_tipo_relacion;
    }

    public String getNom_tipo_relacion() {
        return nom_tipo_relacion;
    }

    public void setNom_tipo_relacion(String nom_tipo_relacion) {
        this.nom_tipo_relacion = nom_tipo_relacion;
    }
    
    
}
