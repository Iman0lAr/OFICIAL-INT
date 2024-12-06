package com.example.demo.Controladores;

import ClasesFormulario.FormCarnet;
import ClasesFormulario.OuputCarnet;
import com.example.demo.Entidades.CertificadoDeDiscapacidad;
import com.example.demo.Entidades.Contacto;
import com.example.demo.Entidades.Direccion;
import com.example.demo.Entidades.Discapacitado;
import com.example.demo.Entidades.DocumentoDeIdentidad;
import com.example.demo.Entidades.Infor_Discapacitado;
import com.example.demo.Entidades.Persona;
import com.example.demo.Entidades.Representante;
import com.example.demo.Entidades.TipoTramite;
import com.example.demo.Entidades.Tramite;
import com.example.demo.Entidades.Usuario;
import com.example.demo.Servicios.ServicioCertificadoDeDiscapacidad;
import com.example.demo.Servicios.ServicioContacto;
import com.example.demo.Servicios.ServicioDireccion;
import com.example.demo.Servicios.ServicioDiscapacitado;
import com.example.demo.Servicios.ServicioDocumentoIdentidad;
import com.example.demo.Servicios.ServicioInfoDiscapacitado;
import com.example.demo.Servicios.ServicioPersona;
import com.example.demo.Servicios.ServicioRepresentante;
import com.example.demo.Servicios.ServicioTramite;
import com.example.demo.Servicios.ServicioUsuario;
import jakarta.transaction.Transactional;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ControllerUpdateTCarnet {

    @Autowired
    private ServicioUsuario servicioUsuario;

    @Autowired
    private ServicioTramite servicioTramite;
    @Autowired
    private ServicioCertificadoDeDiscapacidad servicioCertificadoDeDiscapacidad;

    @Autowired
    private ServicioRepresentante servicioRepresentante;

    @Autowired
    private ServicioInfoDiscapacitado servicioInfoDiscapacitado;

    @Autowired
    private ServicioDocumentoIdentidad servicioDocumentoIdentidad;

    @Autowired
    private ServicioDiscapacitado servDis;

    @Autowired
    private ServicioPersona serviP;

    @Autowired
    private ServicioDireccion servicioDireccion;

    @Autowired
    ServicioPersona servicioPersona;

    @Autowired
    ServicioContacto servicioContacto;

    @GetMapping("/gestionarTramiteCarnet/{id}")
    public String mostrarVista(
            @PathVariable("id") Integer id,
            Model model) {

        try {
            Tramite tramite = servicioTramite.buscarId(id);

            
            
            Infor_Discapacitado infor = servicioInfoDiscapacitado.buscar(tramite.getInfor_Discapacitado().getId_info());
            Discapacitado disc = servDis.buscarId(infor.getDiscapacitado().getId_discapacitado());
            //Persona personaDisc = serviP.buscarPorId(disc.getPersona().getId_persona());

            //Persona perRepre = null;
            Representante repre = null;
            if (infor.getRepresentante() != null) {
                repre = servicioRepresentante.buscarId(infor.getRepresentante().getId_representante());

            }

            OuputCarnet ouputCarnet = new OuputCarnet(
                    tramite,
                    disc,
                    infor.getDireccion(),
                    infor.getCertificadoDeDiscapacidad(),
                    repre,
                    infor.getDireccion_repre(),
                    convertirImagenAStringBase64(disc.getCopiacopia_dni()),
                    (repre == null) ? null : convertirImagenAStringBase64(repre.getCopia_dni()),
                    convertirImagenAStringBase64(infor.getCertificadoDeDiscapacidad().getCopia_cert1()),
                    convertirImagenAStringBase64(infor.getCertificadoDeDiscapacidad().getCopia_cert2()),
                    convertirImagenAStringBase64(tramite.getImg_solicitud()));

            model.addAttribute("tramiteUpdate", ouputCarnet);
        } catch (Exception e) {
            System.out.println(e);
        }

        model.addAttribute("formcarnet", new FormCarnet());
        return "ModificarTramiteCarnet";
    }

    @Transactional
    @PostMapping("/modificarTramiteCarnet/{id}")
    public String ModificarTramiteCarnet(
            @PathVariable("id") Integer id,
            @ModelAttribute(name = "tramiteUpdate") OuputCarnet tramiteUpdate,
            @RequestParam(name = "fechaE") LocalDate fechaE,
            @RequestParam(value = "copiaDniDis", required = false) MultipartFile file,
            @RequestParam(value = "copiaDniRepre", required = false) MultipartFile file2,
            @RequestParam(value = "copiaCerPart1", required = false) MultipartFile file3,
            @RequestParam(value = "copiaCerPart2", required = false) MultipartFile file4,
            @RequestParam(value = "copiaSolicitud", required = false) MultipartFile file5) {
        try {
            Tramite tramite = servicioTramite.buscarId(id);

            Infor_Discapacitado infor = servicioInfoDiscapacitado.buscar(tramite.getInfor_Discapacitado().getId_info());
            Discapacitado disc = servDis.buscarId(infor.getDiscapacitado().getId_discapacitado());

            Representante repre = null;
            if (infor.getRepresentante() != null) {
                repre = servicioRepresentante.buscarId(infor.getRepresentante().getId_representante());

            }

            OuputCarnet infoCarnetExist = new OuputCarnet(
                    tramite,
                    disc,
                    infor.getDireccion(),
                    infor.getCertificadoDeDiscapacidad(),
                    repre,
                    infor.getDireccion_repre(),
                    convertirImagenAStringBase64(disc.getCopiacopia_dni()),
                    (repre == null) ? null : convertirImagenAStringBase64(repre.getCopia_dni()),
                    convertirImagenAStringBase64(infor.getCertificadoDeDiscapacidad().getCopia_cert1()),
                    convertirImagenAStringBase64(infor.getCertificadoDeDiscapacidad().getCopia_cert2()),
                    convertirImagenAStringBase64(tramite.getImg_solicitud()));

            tramiteUpdate.getDirec_disc().setPersona(tramiteUpdate.getDiscapacitado().getPersona());
            Direccion direc_disc = servicioDireccion.guardar(tramiteUpdate.getDirec_disc());

            Direccion direc_repre = null;
            if (!tramiteUpdate.getRepresentante().getPersona().getNombre().trim().isEmpty()) {

                tramiteUpdate.getDirec_repre().setPersona(tramiteUpdate.getRepresentante().getPersona());
                direc_repre = servicioDireccion.guardar(tramiteUpdate.getDirec_repre());
            }

            Discapacitado disc_return = servDis.guardar(direc_disc, obtenerImagen(file));

            Representante represen = servicioRepresentante.guardar((direc_repre == null) ? null : direc_repre.getPersona().getId_persona(), disc_return.getId_discapacitado(), obtenerImagen(file2));

            tramiteUpdate.getCertificadoDeDiscapacidad().setId_certificado(infoCarnetExist.getCertificadoDeDiscapacidad().getId_certificado());
            tramiteUpdate.getCertificadoDeDiscapacidad().setFecha_emision(fechaE);
            tramiteUpdate.getCertificadoDeDiscapacidad().setCopia_cert1(obtenerImagen(file3));
            tramiteUpdate.getCertificadoDeDiscapacidad().setCopia_cert2(obtenerImagen(file4));
            tramiteUpdate.getCertificadoDeDiscapacidad().setDiscapacitado(disc_return);

            CertificadoDeDiscapacidad certificadoReturn = servicioCertificadoDeDiscapacidad.modificarCertificadoDeDiscapacidad(tramiteUpdate.getCertificadoDeDiscapacidad());

            Infor_Discapacitado infor_Discapacitado = new Infor_Discapacitado();
            infor_Discapacitado.setId_info(infoCarnetExist.getTramie().getInfor_Discapacitado().getId_info());
            infor_Discapacitado.setDiscapacitado(disc_return);
            infor_Discapacitado.setRepresentante(represen == null ? null : represen);
            infor_Discapacitado.setCertificadoDeDiscapacidad(certificadoReturn);
            infor_Discapacitado.setDireccion(direc_disc);
            infor_Discapacitado.setDireccion_repre(direc_repre == null ? null : direc_repre);

            Infor_Discapacitado info_return = servicioInfoDiscapacitado.modificar(infor_Discapacitado);

            TipoTramite tipoTramite = new TipoTramite();
            tipoTramite.setId_tipo_tramite(1);
            Contacto contacto = tramiteUpdate.getTramie().getContacto();

            contacto.setId_contacto(infoCarnetExist.getTramie().getContacto().getId_contacto());
            Contacto contactoReturn = servicioContacto.guardar(contacto);
            /* Usuario usuario = new Usuario();
            usuario.setId_Usuario(1);*/
            Tramite tram = new Tramite();
            tram.setId_tramite(infoCarnetExist.getTramie().getId_tramite());
            tram.setInfor_Discapacitado(info_return);
            tram.setContacto(contactoReturn);

            Usuario usuario = new Usuario();
            usuario.setId_Usuario(1);
            tram.setFecha_inicio(infoCarnetExist.getTramie().getFecha_inicio());
            tram.setUsuario(usuario);

            /*   DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            tram.setFecha_inicio(LocalDate.parse(tram.getFecha_inicio().format(formato)));*/
            tram.setTipoTramite(tipoTramite);
            // System.out.println(tram.getFecha_inicio());
            tram.setImg_solicitud(obtenerImagen(file5));

            Tramite tramite_Return = servicioTramite.modificar(tram);
            return "redirect:/gestionarTramiteCarnet/" + tram.getId_tramite();
        } catch (Exception e) {
            System.out.println(e);
        }

        return "redirect:/home";
    }

    private String convertirImagenAStringBase64(byte[] foto) throws IOException {
        return Base64.getEncoder().encodeToString(foto);
    }

    private byte[] obtenerImagen(MultipartFile file) throws IOException {
        if (file == null || file.isEmpty()) {
            return null;
        }
        return file.getBytes();
    }

}
