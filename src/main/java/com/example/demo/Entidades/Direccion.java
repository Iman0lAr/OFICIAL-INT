package com.example.demo.Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_direccion ")
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_direccion;
    
    private String calle;
    private String num_calle;
    private String ref_direccion;
    @Column(name = "centro_Poblado")
    private String centroPoblado;
    
    
    @JoinColumn(name = "id_distrito")
    @ManyToOne
    private Distrito distrito;
    
    @JoinColumn(name = "persona_id")
    @ManyToOne
    private Persona persona;

    public Direccion(Integer id_direccion, String calle, String num_calle, String ref_direccion, Distrito distrito, Persona persona) {
        this.id_direccion = id_direccion;
        this.calle = calle;
        this.num_calle = num_calle;
        this.ref_direccion = ref_direccion;
        this.distrito = distrito;
        this.persona = persona;
    }

    public Direccion() {
    }

    public Integer getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(Integer id_direccion) {
        this.id_direccion = id_direccion;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNum_calle() {
        return num_calle;
    }

    public void setNum_calle(String num_calle) {
        this.num_calle = num_calle;
    }

    public String getRef_direccion() {
        return ref_direccion;
    }

    public void setRef_direccion(String ref_direccion) {
        this.ref_direccion = ref_direccion;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getCentroPoblado() {
        return centroPoblado;
    }

    public void setCentroPoblado(String centroPoblado) {
        this.centroPoblado = centroPoblado;
    }

    
    
    
}
