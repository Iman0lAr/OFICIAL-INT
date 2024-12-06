
package com.example.demo.Entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
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
@Table(name = "tb_usuario")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id_Usuario;
    private String usuario;
    private LocalDate fecha_c;
    
    @Column(name = "password")
    private String contraseña;
    
    private Boolean estado;
    
    @ManyToOne
    @JoinColumn(name = "id_tipo_usuario")
    private TipoUsuario tipoUsuario;
  
    @JsonIgnore
    @OneToOne(mappedBy = "usuario")
    private Persona persona;
    
    @JsonBackReference
    @JoinColumn(name = "usuario_id")
    @OneToOne
    private Usuario usuarioCreador;
    
    public Usuario() {}

    public Usuario(Integer id_Usuario, String usuario, String contraseña, Boolean estado, TipoUsuario tipoUsuario) {
        this.id_Usuario = id_Usuario;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.estado = estado;
        this.tipoUsuario = tipoUsuario;
    }

   
    public Integer getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(Integer id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public LocalDate getFecha_c() {
        return fecha_c;
    }

    public void setFecha_c(LocalDate fecha_c) {
        this.fecha_c = fecha_c;
    }

    public Usuario getUsuarioCreador() {
        return usuarioCreador;
    }

    public void setUsuarioCreador(Usuario usuarioCreador) {
        this.usuarioCreador = usuarioCreador;
    }
    
        
  
    
    
}
