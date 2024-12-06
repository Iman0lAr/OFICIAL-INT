
package com.example.demo.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_contacto")
public class Contacto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_contacto;
    private String tel_fijo;
    private String celular;
    private String correo;

    public Contacto(Integer id_contacto, String tel_fijo, String celular, String correo) {
        this.id_contacto = id_contacto;
        this.tel_fijo = tel_fijo;
        this.celular = celular;
        this.correo = correo;
    }

    public Contacto() {
    }

        
    public Contacto(String tel_fijo, String celular, String correo) {
        this.tel_fijo = tel_fijo;
        this.celular = celular;
        this.correo = correo;
    }

    public Integer getId_contacto() {
        return id_contacto;
    }

    public void setId_contacto(Integer id_contacto) {
        this.id_contacto = id_contacto;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    
    
}
