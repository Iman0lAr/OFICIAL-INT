package com.example.demo.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_representante ")
public class Representante {

    @Id
    private Integer id_representante;

    @OneToOne
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona", insertable = false, updatable = false)
    private Persona persona;

    @Lob // Utiliza @Lob para mapear un campo BLOB o CLOB en la base de datos.
    private byte[] copia_dni; // Aquí se almacenan los datos binarios de la imagen.
    
    private String tel_fijo;
    private String correo;
    
    
    public Representante(Integer id_representante, Persona persona, byte[] copia_dni, String tel_fijo) {
        this.id_representante = id_representante;
        this.persona = persona;
        this.copia_dni = copia_dni;
        this.tel_fijo = tel_fijo;
    }

    public Representante(Persona persona, byte[] copia_dni, String tel_fijo) {
        this.persona = persona;
        this.copia_dni = copia_dni;
        this.tel_fijo = tel_fijo;
    }

    public Representante() {
    }

    
    public Integer getId_representante() {
        return id_representante;
    }

    public void setId_representante(Integer id_representante) {
        this.id_representante = id_representante;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public byte[] getCopia_dni() {
        return copia_dni;
    }

    public void setCopia_dni(byte[] copia_dni) {
        this.copia_dni = copia_dni;
    }

    public String getTel_fijo() {
        return tel_fijo;
    }

    public void setTel_fijo(String tel_fijo) {
        this.tel_fijo = tel_fijo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    
}
