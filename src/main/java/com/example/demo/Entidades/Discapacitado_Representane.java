
package com.example.demo.Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "tb_dis_representante")
public class Discapacitado_Representane {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_dis_representante;
    
    @JoinColumn(name = "id_discapacitado")
    @ManyToOne
    private Discapacitado discapacitado;
    
    @JoinColumn(name = "id_representante")
    @ManyToOne
    private Representante representante;
    
    private LocalDate fecha_relacion;
    
    @JoinColumn(name = "id_tipo_relacion")
    @ManyToOne
    private TipoRelacion tipoRelacion;

    public Discapacitado_Representane(Integer id_dis_representante, Discapacitado discapacitado, Representante representante, LocalDate fecha_relacion, TipoRelacion tipoRelacion) {
        this.id_dis_representante = id_dis_representante;
        this.discapacitado = discapacitado;
        this.representante = representante;
        this.fecha_relacion = fecha_relacion;
        this.tipoRelacion = tipoRelacion;
    }

    
    
    public Discapacitado_Representane(Discapacitado discapacitado, Representante representante, LocalDate fecha_relacion, TipoRelacion tipoRelacion) {
        this.discapacitado = discapacitado;
        this.representante = representante;
        this.fecha_relacion = fecha_relacion;
        this.tipoRelacion = tipoRelacion;
    }

    public Discapacitado_Representane() {
    }

    public Integer getId_dis_representante() {
        return id_dis_representante;
    }

    public void setId_dis_representante(Integer id_dis_representante) {
        this.id_dis_representante = id_dis_representante;
    }

    public Discapacitado getDiscapacitado() {
        return discapacitado;
    }

    public void setDiscapacitado(Discapacitado discapacitado) {
        this.discapacitado = discapacitado;
    }

    public Representante getRepresentante() {
        return representante;
    }

    public void setRepresentante(Representante representante) {
        this.representante = representante;
    }

    public LocalDate getFecha_relacion() {
        return fecha_relacion;
    }

    public void setFecha_relacion(LocalDate fecha_relacion) {
        this.fecha_relacion = fecha_relacion;
    }

    public TipoRelacion getTipoRelacion() {
        return tipoRelacion;
    }

    public void setTipoRelacion(TipoRelacion tipoRelacion) {
        this.tipoRelacion = tipoRelacion;
    }
    
    
}
