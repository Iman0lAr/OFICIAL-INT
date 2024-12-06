
package ClasesFormulario;

import com.example.demo.Entidades.CertificadoDeDiscapacidad;
import com.example.demo.Entidades.Contacto;
import com.example.demo.Entidades.Departamento;
import com.example.demo.Entidades.Direccion;
import com.example.demo.Entidades.Discapacitado;
import com.example.demo.Entidades.Distrito;
import com.example.demo.Entidades.DocumentoDeIdentidad;
import com.example.demo.Entidades.Infor_Discapacitado;
import com.example.demo.Entidades.Persona;
import com.example.demo.Entidades.Provincia;
import com.example.demo.Entidades.Representante;
import com.example.demo.Entidades.Sexo;
import com.example.demo.Entidades.Tramite;


public class FormCarnet {
    
    private Persona persona_dis;
    private Persona persona_repre;
    private Discapacitado discapacitado;
    private Direccion direccion;
    private Tramite tramite;
    private Representante representante;
    private CertificadoDeDiscapacidad certificadoDeDiscapacidad;
    private Contacto contacto;
    private Departamento departamento;
    private Provincia provincia;
    private Distrito distrito;
    private DocumentoDeIdentidad documentoDeIdentidad;
     private DocumentoDeIdentidad documentoDeIdentidad_repre;
    private Infor_Discapacitado infor_Discapacitado;
    private Sexo sexo;
    private Sexo sexo_repre;

    private Departamento departamento_Repre;
    private Provincia provincia_Repre;
    private Distrito distrito_Repre;
    private Direccion direccion_Repre;

    public FormCarnet(Persona persona_dis, Persona persona_repre, Discapacitado discapacitado, Direccion direccion, Tramite tramite, Representante representante, CertificadoDeDiscapacidad certificadoDeDiscapacidad, Contacto contacto, Departamento departamento, Provincia provincia, Distrito distrito, DocumentoDeIdentidad documentoDeIdentidad, DocumentoDeIdentidad documentoDeIdentidad_repre, Infor_Discapacitado infor_Discapacitado, Sexo sexo, Sexo sexo_repre, Departamento departamento_Repre, Provincia provincia_Repre, Distrito distrito_Repre, Direccion direccion_Repre) {
        this.persona_dis = persona_dis;
        this.persona_repre = persona_repre;
        this.discapacitado = discapacitado;
        this.direccion = direccion;
        this.tramite = tramite;
        this.representante = representante;
        this.certificadoDeDiscapacidad = certificadoDeDiscapacidad;
        this.contacto = contacto;
        this.departamento = departamento;
        this.provincia = provincia;
        this.distrito = distrito;
        this.documentoDeIdentidad = documentoDeIdentidad;
        this.documentoDeIdentidad_repre = documentoDeIdentidad_repre;
        this.infor_Discapacitado = infor_Discapacitado;
        this.sexo = sexo;
        this.sexo_repre = sexo_repre;
        this.departamento_Repre = departamento_Repre;
        this.provincia_Repre = provincia_Repre;
        this.distrito_Repre = distrito_Repre;
        this.direccion_Repre = direccion_Repre;
    }

    public FormCarnet() {
    }

    public Persona getPersona_dis() {
        return persona_dis;
    }

    public void setPersona_dis(Persona persona_dis) {
        this.persona_dis = persona_dis;
    }

    public Persona getPersona_repre() {
        return persona_repre;
    }

    public void setPersona_repre(Persona persona_repre) {
        this.persona_repre = persona_repre;
    }

    public Discapacitado getDiscapacitado() {
        return discapacitado;
    }

    public void setDiscapacitado(Discapacitado discapacitado) {
        this.discapacitado = discapacitado;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Tramite getTramite() {
        return tramite;
    }

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }

    public Representante getRepresentante() {
        return representante;
    }

    public void setRepresentante(Representante representante) {
        this.representante = representante;
    }

    public CertificadoDeDiscapacidad getCertificadoDeDiscapacidad() {
        return certificadoDeDiscapacidad;
    }

    public void setCertificadoDeDiscapacidad(CertificadoDeDiscapacidad certificadoDeDiscapacidad) {
        this.certificadoDeDiscapacidad = certificadoDeDiscapacidad;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }

    public DocumentoDeIdentidad getDocumentoDeIdentidad() {
        return documentoDeIdentidad;
    }

    public void setDocumentoDeIdentidad(DocumentoDeIdentidad documentoDeIdentidad) {
        this.documentoDeIdentidad = documentoDeIdentidad;
    }

    public DocumentoDeIdentidad getDocumentoDeIdentidad_repre() {
        return documentoDeIdentidad_repre;
    }

    public void setDocumentoDeIdentidad_repre(DocumentoDeIdentidad documentoDeIdentidad_repre) {
        this.documentoDeIdentidad_repre = documentoDeIdentidad_repre;
    }

    public Infor_Discapacitado getInfor_Discapacitado() {
        return infor_Discapacitado;
    }

    public void setInfor_Discapacitado(Infor_Discapacitado infor_Discapacitado) {
        this.infor_Discapacitado = infor_Discapacitado;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Sexo getSexo_repre() {
        return sexo_repre;
    }

    public void setSexo_repre(Sexo sexo_repre) {
        this.sexo_repre = sexo_repre;
    }

    public Departamento getDepartamento_Repre() {
        return departamento_Repre;
    }

    public void setDepartamento_Repre(Departamento departamento_Repre) {
        this.departamento_Repre = departamento_Repre;
    }

    public Provincia getProvincia_Repre() {
        return provincia_Repre;
    }

    public void setProvincia_Repre(Provincia provincia_Repre) {
        this.provincia_Repre = provincia_Repre;
    }

    public Distrito getDistrito_Repre() {
        return distrito_Repre;
    }

    public void setDistrito_Repre(Distrito distrito_Repre) {
        this.distrito_Repre = distrito_Repre;
    }

    public Direccion getDireccion_Repre() {
        return direccion_Repre;
    }

    public void setDireccion_Repre(Direccion direccion_Repre) {
        this.direccion_Repre = direccion_Repre;
    }
    
    
    
}
