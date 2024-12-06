package com.example.demo.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "tb_certificado_discapacidad")
public class CertificadoDeDiscapacidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_certificado;
    private String num_certificado;
    private LocalDate fecha_emision;
    @Lob 
    private byte[] copia_cert1;
    @Lob 
    private byte[] copia_cert2; 
    @JoinColumn(name = "id_discapacitado")
    @ManyToOne
    private Discapacitado discapacitado;

    public CertificadoDeDiscapacidad(Integer id_certificado, String num_certificado, LocalDate fecha_emision, byte[] copia_cert1, byte[] copia_cert2, Discapacitado discapacitado) {
        this.id_certificado = id_certificado;
        this.num_certificado = num_certificado;
        this.fecha_emision = fecha_emision;
        this.copia_cert1 = copia_cert1;
        this.copia_cert2 = copia_cert2;
        this.discapacitado = discapacitado;
    }

    public CertificadoDeDiscapacidad(String num_certificado, LocalDate fecha_emision, byte[] copia_cert1, byte[] copia_cert2, Discapacitado discapacitado) {
        this.num_certificado = num_certificado;
        this.fecha_emision = fecha_emision;
        this.copia_cert1 = copia_cert1;
        this.copia_cert2 = copia_cert2;
        this.discapacitado = discapacitado;
    }

    public CertificadoDeDiscapacidad() {
    }
    
    
    public Integer getId_certificado() {
        return id_certificado;
    }

    public void setId_certificado(Integer id_certificado) {
        this.id_certificado = id_certificado;
    }

    public String getNum_certificado() {
        return num_certificado;
    }

    public void setNum_certificado(String num_certificado) {
        this.num_certificado = num_certificado;
    }

    public LocalDate getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(LocalDate fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public byte[] getCopia_cert1() {
        return copia_cert1;
    }

    public void setCopia_cert1(byte[] copia_cert1) {
        this.copia_cert1 = copia_cert1;
    }

    public byte[] getCopia_cert2() {
        return copia_cert2;
    }

    public void setCopia_cert2(byte[] copia_cert2) {
        this.copia_cert2 = copia_cert2;
    }

    public Discapacitado getDiscapacitado() {
        return discapacitado;
    }

    public void setDiscapacitado(Discapacitado discapacitado) {
        this.discapacitado = discapacitado;
    }
    
    
    
    
}
