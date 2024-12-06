
package com.example.demo.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_estudios")
public class Estudios {
    
    @Id
    @GeneratedValue
    private Integer id_estudios;
    private String desc_estudios;
    
    @JoinColumn(name = "id_nivel")
    @ManyToOne
    private NivelEstudio nivelEstudio;

    public Estudios(Integer id_estudios, String desc_estudios, NivelEstudio nivelEstudio) {
        this.id_estudios = id_estudios;
        this.desc_estudios = desc_estudios;
        this.nivelEstudio = nivelEstudio;
    }

    public Estudios(String desc_estudios, NivelEstudio nivelEstudio) {
        this.desc_estudios = desc_estudios;
        this.nivelEstudio = nivelEstudio;
    }

    public Estudios() {
    }
 
    public Integer getId_estudios() {
        return id_estudios;
    }

    public void setId_estudios(Integer id_estudios) {
        this.id_estudios = id_estudios;
    }

    public String getDesc_estudios() {
        return desc_estudios;
    }

    public void setDesc_estudios(String desc_estudios) {
        this.desc_estudios = desc_estudios;
    }

    public NivelEstudio getNivelEstudio() {
        return nivelEstudio;
    }

    public void setNivelEstudio(NivelEstudio nivelEstudio) {
        this.nivelEstudio = nivelEstudio;
    }
    
    
}
