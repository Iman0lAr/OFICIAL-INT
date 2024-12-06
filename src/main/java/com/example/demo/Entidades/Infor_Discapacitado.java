
package com.example.demo.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_info_discapacitado")
public class Infor_Discapacitado {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_info;
    
    @JoinColumn(name = "id_certificado")
    @ManyToOne
    private CertificadoDeDiscapacidad CertificadoDeDiscapacidad;
    @JoinColumn(name = "id_direccion")
    @ManyToOne
    private Direccion Direccion;
    @JoinColumn(name = "id_discapacitado")
    @ManyToOne
    private Discapacitado Discapacitado;
    @JoinColumn(name = "id_representante")
    @ManyToOne
    private Representante representante;
    
    //para la guardar un historico de las direcciones
    @JoinColumn(name = "id_Direccion_Representante")
    @ManyToOne
    private Direccion Direccion_repre;

    public Infor_Discapacitado(Integer id_info, CertificadoDeDiscapacidad CertificadoDeDiscapacidad, Direccion Direccion, Discapacitado Discapacitado, Representante representante, Direccion Direccion_repre) {
        this.id_info = id_info;
        this.CertificadoDeDiscapacidad = CertificadoDeDiscapacidad;
        this.Direccion = Direccion;
        this.Discapacitado = Discapacitado;
        this.representante = representante;
        this.Direccion_repre = Direccion_repre;
    }

    public Infor_Discapacitado() {
    }
   
    
    public Integer getId_info() {
        return id_info;
    }

    public void setId_info(Integer id_info) {
        this.id_info = id_info;
    }

    public CertificadoDeDiscapacidad getCertificadoDeDiscapacidad() {
        return CertificadoDeDiscapacidad;
    }

    public void setCertificadoDeDiscapacidad(CertificadoDeDiscapacidad CertificadoDeDiscapacidad) {
        this.CertificadoDeDiscapacidad = CertificadoDeDiscapacidad;
    }

    public Direccion getDireccion() {
        return Direccion;
    }

    public void setDireccion(Direccion Direccion) {
        this.Direccion = Direccion;
    }

    public Discapacitado getDiscapacitado() {
        return Discapacitado;
    }

    public void setDiscapacitado(Discapacitado Discapacitado) {
        this.Discapacitado = Discapacitado;
    }

    public Representante getRepresentante() {
        return representante;
    }

    public void setRepresentante(Representante representante) {
        this.representante = representante;
    }

    public Direccion getDireccion_repre() {
        return Direccion_repre;
    }

    public void setDireccion_repre(Direccion Direccion_repre) {
        this.Direccion_repre = Direccion_repre;
    }

    
    

}
