
package com.example.demo.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_documento_identidad")
public class DocumentoDeIdentidad {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_documento;
    private String nro_documento ;
    @JoinColumn(name = "tipo_documento")
    @ManyToOne
    private TipoDocumento tipoDocumento;

    public DocumentoDeIdentidad(Integer id_documento, String nro_documento, TipoDocumento tipoDocumento) {
        this.id_documento = id_documento;
        this.nro_documento = nro_documento;
        this.tipoDocumento = tipoDocumento;
    }

    public DocumentoDeIdentidad(String nro_documento, TipoDocumento tipoDocumento) {
        this.nro_documento = nro_documento;
        this.tipoDocumento = tipoDocumento;
    }

    public DocumentoDeIdentidad() {
    }

    public Integer getId_documento() {
        return id_documento;
    }

    public void setId_documento(Integer id_documento) {
        this.id_documento = id_documento;
    }

    public String getNro_documento() {
        return nro_documento;
    }

    public void setNro_documento(String nro_documento) {
        this.nro_documento = nro_documento;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
    
    
}
