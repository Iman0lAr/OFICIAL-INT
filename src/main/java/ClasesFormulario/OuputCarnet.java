
package ClasesFormulario;

import com.example.demo.Entidades.CertificadoDeDiscapacidad;
import com.example.demo.Entidades.Direccion;
import com.example.demo.Entidades.Discapacitado;
import com.example.demo.Entidades.Discapacitado_Representane;
import com.example.demo.Entidades.Representante;
import com.example.demo.Entidades.TipoRelacion;
import com.example.demo.Entidades.Tramite;

public class OuputCarnet {
    
    private Tramite tramie;
    private Discapacitado discapacitado;
    private Direccion direc_disc;
    private CertificadoDeDiscapacidad certificadoDeDiscapacidad;
    private Representante representante;
    private Direccion direc_repre;
    private String copia_dni_disc;
    private String copia_dni_representante;
    private String copia_cer1;
    private String copia_cer2;
    private String imagen_solicitud;

    private Discapacitado_Representane discapacitado_Representane;
    
    public OuputCarnet(Tramite tramie, Discapacitado discapacitado, Direccion direc_disc, CertificadoDeDiscapacidad certificadoDeDiscapacidad, Representante representante, Direccion direc_repre, String copia_dni_disc, String copia_dni_representante, String copia_cer1, String copia_cer2, String imagen_solicitud) {
        this.tramie = tramie;
        this.discapacitado = discapacitado;
        this.direc_disc = direc_disc;
        this.certificadoDeDiscapacidad = certificadoDeDiscapacidad;
        this.representante = representante;
        this.direc_repre = direc_repre;
        this.copia_dni_disc = copia_dni_disc;
        this.copia_dni_representante = copia_dni_representante;
        this.copia_cer1 = copia_cer1;
        this.copia_cer2 = copia_cer2;
        this.imagen_solicitud = imagen_solicitud;
    }

    public OuputCarnet(Tramite tramie, Discapacitado discapacitado, Direccion direc_disc, CertificadoDeDiscapacidad certificadoDeDiscapacidad, Representante representante, String copia_cer1, String copia_cer2, String imagen_solicitud) {
        this.tramie = tramie;
        this.discapacitado = discapacitado;
        this.direc_disc = direc_disc;
        this.certificadoDeDiscapacidad = certificadoDeDiscapacidad;
        this.representante = representante;
        this.copia_cer1 = copia_cer1;
        this.copia_cer2 = copia_cer2;
        this.imagen_solicitud = imagen_solicitud;
    }

    
    
    
    public OuputCarnet() {
    }

    public Discapacitado_Representane getDiscapacitado_Representane() {
        return discapacitado_Representane;
    }

    public void setDiscapacitado_Representane(Discapacitado_Representane discapacitado_Representane) {
        this.discapacitado_Representane = discapacitado_Representane;
    }

 
    
    
    public Tramite getTramie() {
        return tramie;
    }

    public void setTramie(Tramite tramie) {
        this.tramie = tramie;
    }

    public Discapacitado getDiscapacitado() {
        return discapacitado;
    }

    public void setDiscapacitado(Discapacitado discapacitado) {
        this.discapacitado = discapacitado;
    }

    public Direccion getDirec_disc() {
        return direc_disc;
    }

    public void setDirec_disc(Direccion direc_disc) {
        this.direc_disc = direc_disc;
    }

    public CertificadoDeDiscapacidad getCertificadoDeDiscapacidad() {
        return certificadoDeDiscapacidad;
    }

    public void setCertificadoDeDiscapacidad(CertificadoDeDiscapacidad certificadoDeDiscapacidad) {
        this.certificadoDeDiscapacidad = certificadoDeDiscapacidad;
    }

    public Representante getRepresentante() {
        return representante;
    }

    public void setRepresentante(Representante representante) {
        this.representante = representante;
    }

    public Direccion getDirec_repre() {
        return direc_repre;
    }

    public void setDirec_repre(Direccion direc_repre) {
        this.direc_repre = direc_repre;
    }

    public String getCopia_dni_disc() {
        return copia_dni_disc;
    }

    public void setCopia_dni_disc(String copia_dni_disc) {
        this.copia_dni_disc = copia_dni_disc;
    }

    public String getCopia_dni_representante() {
        return copia_dni_representante;
    }

    public void setCopia_dni_representante(String copia_dni_representante) {
        this.copia_dni_representante = copia_dni_representante;
    }

    public String getCopia_cer1() {
        return copia_cer1;
    }

    public void setCopia_cer1(String copia_cer1) {
        this.copia_cer1 = copia_cer1;
    }

    public String getCopia_cer2() {
        return copia_cer2;
    }

    public void setCopia_cer2(String copia_cer2) {
        this.copia_cer2 = copia_cer2;
    }

    public String getImagen_solicitud() {
        return imagen_solicitud;
    }

    public void setImagen_solicitud(String imagen_solicitud) {
        this.imagen_solicitud = imagen_solicitud;
    }
    
    
    
    
}
