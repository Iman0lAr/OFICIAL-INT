

package com.example.demo.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_tipo_tramite")
public class TipoTramite {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_tipo_tramite;
    private String nom_tipo_tramite;

    public TipoTramite(Integer id_tipo_tramite, String nom_tipo_tramite) {
        this.id_tipo_tramite = id_tipo_tramite;
        this.nom_tipo_tramite = nom_tipo_tramite;
    }

    public TipoTramite() {
    }

    public TipoTramite(String nom_tipo_tramite) {
        this.nom_tipo_tramite = nom_tipo_tramite;
    }

    public Integer getId_tipo_tramite() {
        return id_tipo_tramite;
    }

    public void setId_tipo_tramite(Integer id_tipo_tramite) {
        this.id_tipo_tramite = id_tipo_tramite;
    }

    public String getNom_tipo_tramite() {
        return nom_tipo_tramite;
    }

    public void setNom_tipo_tramite(String nom_tipo_tramite) {
        this.nom_tipo_tramite = nom_tipo_tramite;
    }
    
    
}
