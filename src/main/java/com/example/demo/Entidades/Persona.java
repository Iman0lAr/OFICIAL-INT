
package com.example.demo.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "tb_persona")
public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_persona;
    private String nombre;
    private String apell_paterno;
    private String apell_materno;
    @JoinColumn(name=" id_sexo ")
    @ManyToOne
    private Sexo sexo;
    @JoinColumn(name ="id_usuario")
    @OneToOne
    private Usuario usuario;
    @JoinColumn(name ="id_documento " )
    @OneToOne
    private DocumentoDeIdentidad documentoDeIdentidad;

    public Persona(Integer id_persona, String nombre, String apell_paterno, String apell_materno, Sexo sexo, Usuario usuario, DocumentoDeIdentidad documentoDeIdentidad) {
        this.id_persona = id_persona;
        this.nombre = nombre;
        this.apell_paterno = apell_paterno;
        this.apell_materno = apell_materno;
        this.sexo = sexo;
        this.usuario = usuario;
        this.documentoDeIdentidad = documentoDeIdentidad;
    }

    public Persona(String nombre, String apell_paterno, String apell_materno, Sexo sexo, Usuario usuario, DocumentoDeIdentidad documentoDeIdentidad) {
        this.nombre = nombre;
        this.apell_paterno = apell_paterno;
        this.apell_materno = apell_materno;
        this.sexo = sexo;
        this.usuario = usuario;
        this.documentoDeIdentidad = documentoDeIdentidad;
    }

    public Persona() {
    }

    public Integer getId_persona() {
        return id_persona;
    }

    public void setId_persona(Integer id_persona) {
        this.id_persona = id_persona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApell_paterno() {
        return apell_paterno;
    }

    public void setApell_paterno(String apell_paterno) {
        this.apell_paterno = apell_paterno;
    }

    public String getApell_materno() {
        return apell_materno;
    }

    public void setApell_materno(String apell_materno) {
        this.apell_materno = apell_materno;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public DocumentoDeIdentidad getDocumentoDeIdentidad() {
        return documentoDeIdentidad;
    }

    public void setDocumentoDeIdentidad(DocumentoDeIdentidad documentoDeIdentidad) {
        this.documentoDeIdentidad = documentoDeIdentidad;
    }
    
    
    
}
