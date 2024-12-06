
package com.example.demo.Entidades;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.time.LocalDate;

@Entity
@Table(name = "tb_tramite")
public class Tramite {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_tramite;
    private LocalDate fecha_inicio;
    private Boolean estado;
    @Lob
    private byte[] img_solicitud; 
    @JoinColumn(name = "id_contacto")
    @OneToOne(cascade = CascadeType.PERSIST) 
    private Contacto contacto;
    
   
    @JoinColumn(name = "id_Info_Discapacitado")
    @OneToOne 
    private Infor_Discapacitado infor_Discapacitado;
    
    @JoinColumn(name = "id_tipo_tramite")
    @ManyToOne
    private TipoTramite tipoTramite;
    
    @JoinColumn(name = "id_usuario")
    @ManyToOne
    private Usuario usuario;

    public Tramite(Integer id_tramite, LocalDate fecha_inicio, Boolean estado, byte[] img_solicitud, Contacto contacto, Infor_Discapacitado infor_Discapacitado, TipoTramite tipoTramite, Usuario usuario) {
        this.id_tramite = id_tramite;
        this.fecha_inicio = fecha_inicio;
        this.estado = estado;
        this.img_solicitud = img_solicitud;
        this.contacto = contacto;
        this.infor_Discapacitado = infor_Discapacitado;
        this.tipoTramite = tipoTramite;
        this.usuario = usuario;
    }

    public Tramite(LocalDate fecha_inicio, Boolean estado, byte[] img_solicitud, Contacto contacto, Infor_Discapacitado infor_Discapacitado, TipoTramite tipoTramite, Usuario usuario) {
        this.fecha_inicio = fecha_inicio;
        this.estado = estado;
        this.img_solicitud = img_solicitud;
        this.contacto = contacto;
        this.infor_Discapacitado = infor_Discapacitado;
        this.tipoTramite = tipoTramite;
        this.usuario = usuario;
    }

    public Tramite() {  }
    
    public Integer getId_tramite() {
        return id_tramite;
    }

    public void setId_tramite(Integer id_tramite) {
        this.id_tramite = id_tramite;
    }

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public byte[] getImg_solicitud() {
        return img_solicitud;
    }

    public void setImg_solicitud(byte[] img_solicitud) {
        this.img_solicitud = img_solicitud;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    public Infor_Discapacitado getInfor_Discapacitado() {
        return infor_Discapacitado;
    }

    public void setInfor_Discapacitado(Infor_Discapacitado infor_Discapacitado) {
        this.infor_Discapacitado = infor_Discapacitado;
    }

    public TipoTramite getTipoTramite() {
        return tipoTramite;
    }

    public void setTipoTramite(TipoTramite tipoTramite) {
        this.tipoTramite = tipoTramite;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


    
}
