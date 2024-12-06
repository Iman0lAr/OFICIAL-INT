package com.example.demo.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "tb_discapacitado")
public class Discapacitado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_discapacitado;

    @OneToOne
    @JoinColumn(name = "id_persona")
    private Persona persona;
    private String est_civil;

    @Lob // Utiliza @Lob para mapear un campo BLOB o CLOB en la base de datos.
    private byte[] copia_dni; // Aquí se almacenan los datos binarios de la imagen.
    private String com_indigena;
    private String len_originaria;
    private String autopercepcion;
    private Boolean mani_voluntad;
    private LocalDate fecha_Nac;
    private String tel_fijo;
    private String celular;
    private String correo;
    private Boolean difi_ir_banco;
    
    @JoinColumn(name = "id_estudios")
    @OneToOne
    private Estudios estudios;

    public Discapacitado(Integer id_discapacitado, Persona persona, String est_civil, byte[] Copiacopia_dni, String com_indigena, String len_originaria, String autopercepcion, Boolean mani_voluntad, LocalDate fecha_Nac, String tel_fijo, String celular, Boolean difi_ir_banco, Estudios estudios) {
        this.id_discapacitado = id_discapacitado;
        this.persona = persona;
        this.est_civil = est_civil;
        this.copia_dni = Copiacopia_dni;
        this.com_indigena = com_indigena;
        this.len_originaria = len_originaria;
        this.autopercepcion = autopercepcion;
        this.mani_voluntad = mani_voluntad;
        this.fecha_Nac = fecha_Nac;
        this.tel_fijo = tel_fijo;
        this.celular = celular;
        this.difi_ir_banco = difi_ir_banco;
        this.estudios = estudios;
    }

    public Discapacitado(Persona persona, String est_civil, byte[] Copiacopia_dni, String com_indigena, String len_originaria, String autopercepcion, Boolean mani_voluntad, LocalDate fecha_Nac, String tel_fijo, String celular, Boolean difi_ir_banco, Estudios estudios) {
        this.persona = persona;
        this.est_civil = est_civil;
        this.copia_dni = Copiacopia_dni;
        this.com_indigena = com_indigena;
        this.len_originaria = len_originaria;
        this.autopercepcion = autopercepcion;
        this.mani_voluntad = mani_voluntad;
        this.fecha_Nac = fecha_Nac;
        this.tel_fijo = tel_fijo;
        this.celular = celular;
        this.difi_ir_banco = difi_ir_banco;
        this.estudios = estudios;
    }

    public Discapacitado() {
    }

    
    
    public Integer getId_discapacitado() {
        return id_discapacitado;
    }

    public void setId_discapacitado(Integer id_discapacitado) {
        this.id_discapacitado = id_discapacitado;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getEst_civil() {
        return est_civil;
    }

    public void setEst_civil(String est_civil) {
        this.est_civil = est_civil;
    }

    public byte[] getCopiacopia_dni() {
        return copia_dni;
    }

    public void setCopiacopia_dni(byte[] Copiacopia_dni) {
        this.copia_dni = Copiacopia_dni;
    }

    public String getCom_indigena() {
        return com_indigena;
    }

    public void setCom_indigena(String com_indigena) {
        this.com_indigena = com_indigena;
    }

    public String getLen_originaria() {
        return len_originaria;
    }

    public void setLen_originaria(String len_originaria) {
        this.len_originaria = len_originaria;
    }

    public String getAutopercepcion() {
        return autopercepcion;
    }

    public void setAutopercepcion(String autopercepcion) {
        this.autopercepcion = autopercepcion;
    }

    public Boolean getMani_voluntad() {
        return mani_voluntad;
    }

    public void setMani_voluntad(Boolean mani_voluntad) {
        this.mani_voluntad = mani_voluntad;
    }

    public LocalDate getFecha_Nac() {
        return fecha_Nac;
    }

    public void setFecha_Nac(LocalDate fecha_Nac) {
        this.fecha_Nac = fecha_Nac;
    }

    public String getTel_fijo() {
        return tel_fijo;
    }

    public void setTel_fijo(String tel_fijo) {
        this.tel_fijo = tel_fijo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Boolean getDifi_ir_banco() {
        return difi_ir_banco;
    }

    public void setDifi_ir_banco(Boolean difi_ir_banco) {
        this.difi_ir_banco = difi_ir_banco;
    }

    public Estudios getEstudios() {
        return estudios;
    }

    public void setEstudios(Estudios estudios) {
        this.estudios = estudios;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    
}
