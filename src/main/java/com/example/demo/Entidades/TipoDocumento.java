
package com.example.demo.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_tipo_documento")
public class TipoDocumento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_tipo_documento;
    private String nom_tipo_documento;

    public TipoDocumento(Integer id_tipo_documento, String nom_tipo_documento) {
        this.id_tipo_documento = id_tipo_documento;
        this.nom_tipo_documento = nom_tipo_documento;
    }

    public TipoDocumento() {
    }

    public TipoDocumento(String nom_tipo_documento) {
        this.nom_tipo_documento = nom_tipo_documento;
    }

    public Integer getId_tipo_documento() {
        return id_tipo_documento;
    }

    public void setId_tipo_documento(Integer id_tipo_documento) {
        this.id_tipo_documento = id_tipo_documento;
    }

    public String getNom_tipo_documento() {
        return nom_tipo_documento;
    }

    public void setNom_tipo_documento(String nom_tipo_documento) {
        this.nom_tipo_documento = nom_tipo_documento;
    }
    
    
}
