package com.example.demo.Controladores;

import ClasesFormulario.FormCarnet;
import ClasesFormulario.OuputCarnet;
import com.example.demo.Entidades.CertificadoDeDiscapacidad;
import com.example.demo.Entidades.Direccion;
import com.example.demo.Entidades.Discapacitado;
import com.example.demo.Entidades.Discapacitado_Representane;
import com.example.demo.Entidades.DocumentoDeIdentidad;
import com.example.demo.Entidades.Infor_Discapacitado;
import com.example.demo.Entidades.Persona;
import com.example.demo.Entidades.Representante;
import com.example.demo.Entidades.TipoRelacion;
import com.example.demo.Entidades.TipoTramite;
import com.example.demo.Entidades.Tramite;
import com.example.demo.Entidades.Usuario;
import com.example.demo.Servicios.ServicioCertificadoDeDiscapacidad;
import com.example.demo.Servicios.ServicioContacto;
import com.example.demo.Servicios.ServicioDireccion;
import com.example.demo.Servicios.ServicioDis_Representante;
import com.example.demo.Servicios.ServicioDiscapacitado;
import com.example.demo.Servicios.ServicioDocumentoIdentidad;
import com.example.demo.Servicios.ServicioInfoDiscapacitado;
import com.example.demo.Servicios.ServicioNivelEstudios;
import com.example.demo.Servicios.ServicioPersona;
import com.example.demo.Servicios.ServicioRepresentante;
import com.example.demo.Servicios.ServicioTipoRelacion;
import com.example.demo.Servicios.ServicioTramite;
import com.example.demo.Servicios.ServicioUsuario;
import jakarta.transaction.Transactional;
import java.io.IOException;
import java.time.LocalDate;
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
public class ControllerModificarTramitePC {

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
    private ServicioPersona servicioPersona;

    @Autowired
    ServicioContacto servicioContacto;

    @Autowired
    private ServicioTipoRelacion servicioTipoRelacion;

    @Autowired
    private ServicioNivelEstudios servicioNivelEstudios;

    @Autowired
    private ServicioDis_Representante servicioDis_Representante;


    
    @GetMapping("/modificarTramiteProgramaContigo/{id}")
    public String mostrarVista(Model model,
            @PathVariable("id") Integer id
    ) {

        try {
            Tramite tramite = servicioTramite.buscarId(id);

            Infor_Discapacitado infor = servicioInfoDiscapacitado.buscar(tramite.getInfor_Discapacitado().getId_info());
            Discapacitado disc = servDis.buscarId(infor.getDiscapacitado().getId_discapacitado());

            Representante repre = null;
            Discapacitado_Representane discapacitado_Representane = new Discapacitado_Representane();
            TipoRelacion tipo = new TipoRelacion();
            tipo.setId_tipo_relacion(-2);
            discapacitado_Representane.setTipoRelacion(tipo);
            if (infor.getRepresentante() != null) {
                repre = servicioRepresentante.buscarId(infor.getRepresentante().getId_representante());
                discapacitado_Representane = servicioDis_Representante.buscarPorDiscRepre(disc.getId_discapacitado(), repre.getId_representante());

            }

            OuputCarnet ouputCarnet = new OuputCarnet(
                    tramite,
                    disc,
                    infor.getDireccion(),
                    infor.getCertificadoDeDiscapacidad(),
                    repre,
                    infor.getCertificadoDeDiscapacidad().getCopia_cert1() == null ? null : convertirImagenAStringBase64(infor.getCertificadoDeDiscapacidad().getCopia_cert1()),
                    infor.getCertificadoDeDiscapacidad().getCopia_cert2() == null ? null : convertirImagenAStringBase64(infor.getCertificadoDeDiscapacidad().getCopia_cert2()),
                    tramite.getImg_solicitud() == null ? null : convertirImagenAStringBase64(tramite.getImg_solicitud()));

            ouputCarnet.setDiscapacitado_Representane(discapacitado_Representane);

            model.addAttribute("tramiteUpdate", ouputCarnet);
            model.addAttribute("parentescos", new ArrayList<>(servicioTipoRelacion.findAll()));
            model.addAttribute("nivelEstudios", new ArrayList<>(servicioNivelEstudios.findAll()));
        } catch (Exception e) {
            System.out.println(e);
        }

        return "ModificarTramtePc";
    }

    @Transactional
    @PostMapping("/guardarCambios/{id}")
    public String modificarTramitePC(
            @PathVariable("id") Integer id,
            @RequestParam(name = "fecE") LocalDate fecE,
            @RequestParam(name = "fechN") LocalDate fechN,
            @ModelAttribute(name = "tramiteUpdate") OuputCarnet tramiteUpdate,
            @RequestParam(name = "autoPersepcion") String autoPersepcion,
            @RequestParam(name = "nivelEstudio") String nivelEstudio,
            @RequestParam(value = "copiaCerPart2", required = false) MultipartFile copiaCerPart2,
            @RequestParam(value = "copiaCerPart1", required = false) MultipartFile copiaCerPart1,
            @RequestParam(value = "parentesco", required = false) String parentesco,
            @RequestParam(value = "hoja1", required = false) MultipartFile hoja1,
            @RequestParam(value = "hoja2", required = false) MultipartFile hoja2
    ) {
        
        System.out.println("dentro del controller");
        try {
            Tramite tramite = servicioTramite.buscarId(id);

            Infor_Discapacitado infor = servicioInfoDiscapacitado.buscar(tramite.getInfor_Discapacitado().getId_info());
            Discapacitado disc = servDis.buscarId(infor.getDiscapacitado().getId_discapacitado());

            Representante repre = null;
            Discapacitado_Representane discapacitado_Representane = new Discapacitado_Representane();
            TipoRelacion tipo = new TipoRelacion();
            tipo.setId_tipo_relacion(-2);
            discapacitado_Representane.setTipoRelacion(tipo);
            if (infor.getRepresentante() != null) {
                repre = servicioRepresentante.buscarId(infor.getRepresentante().getId_representante());
                discapacitado_Representane = servicioDis_Representante.buscarPorDiscRepre(disc.getId_discapacitado(), repre.getId_representante());

            }

            OuputCarnet ouput = new OuputCarnet(
                    tramite,
                    disc,
                    infor.getDireccion(),
                    infor.getCertificadoDeDiscapacidad(),
                    repre,
                    infor.getCertificadoDeDiscapacidad().getCopia_cert1() == null ? null : convertirImagenAStringBase64(infor.getCertificadoDeDiscapacidad().getCopia_cert1()),
                    infor.getCertificadoDeDiscapacidad().getCopia_cert2() == null ? null : convertirImagenAStringBase64(infor.getCertificadoDeDiscapacidad().getCopia_cert2()),
                    tramite.getImg_solicitud() == null ? null : convertirImagenAStringBase64(tramite.getImg_solicitud()));

            ouput.setDiscapacitado_Representane(discapacitado_Representane);
            
            
            
    

            Direccion direccion=tramiteUpdate.getDirec_disc();
            direccion.setPersona(tramiteUpdate.getDiscapacitado().getPersona());
            
            Direccion direc_Dis = servicioDireccion.guardarPC(direccion);
            System.out.println(direc_Dis.getPersona().getId_persona());
            
            
            
            Persona personaReprereturn = servicioPersona.insertarPersonaRepresentante(tramiteUpdate.getRepresentante().getPersona());

            tramiteUpdate.getDiscapacitado().setAutopercepcion(autoPersepcion);
            tramiteUpdate.getDiscapacitado().setFecha_Nac(fechN);
            Discapacitado disc_return =servDis.insertDiscPc(direc_Dis.getPersona().getId_persona(),tramiteUpdate.getDiscapacitado(), tramiteUpdate.getDiscapacitado().getEstudios().getDesc_estudios(),Integer.parseInt(nivelEstudio));

             Representante represen=null;
             System.out.println(tramiteUpdate.getRepresentante().getPersona().getNombre());
             if(!tramiteUpdate.getRepresentante().getPersona().getNombre().trim().isEmpty()){   
                 System.out.println("dentro del if");
                 represen= servicioRepresentante.insertarRepresentantePc(tramiteUpdate.getRepresentante(), personaReprereturn.getId_persona(), disc_return.getId_discapacitado(), Integer.parseInt(parentesco));
             }
      
            CertificadoDeDiscapacidad certificadoDeDiscapacidad = tramiteUpdate.getCertificadoDeDiscapacidad();
            certificadoDeDiscapacidad.setId_certificado(ouput.getCertificadoDeDiscapacidad().getId_certificado());
            certificadoDeDiscapacidad.setDiscapacitado(disc_return);
            certificadoDeDiscapacidad.setFecha_emision(fechN);
      
            certificadoDeDiscapacidad.setCopia_cert1( copiaCerPart1==null? null: obtenerImagen(copiaCerPart1)); // Convierte el archivo en un arreglo de bytes
            certificadoDeDiscapacidad.setCopia_cert2( copiaCerPart2==null? null:obtenerImagen(copiaCerPart2));

            CertificadoDeDiscapacidad cer_return = servicioCertificadoDeDiscapacidad.modificarCertificadoDeDiscapacidad(certificadoDeDiscapacidad);

            Infor_Discapacitado infor_Discapacitado = new Infor_Discapacitado();
            infor_Discapacitado.setId_info(ouput.getTramie().getInfor_Discapacitado().getId_info());
            infor_Discapacitado.setDiscapacitado(disc_return);
           
            infor_Discapacitado.setRepresentante((represen==null)?null:represen);
            
            infor_Discapacitado.setCertificadoDeDiscapacidad(cer_return);
            infor_Discapacitado.setDireccion(direc_Dis);
            infor_Discapacitado.setDireccion_repre(null);
            
            Infor_Discapacitado info_return = servicioInfoDiscapacitado.modificar(infor_Discapacitado);

            TipoTramite tipoTramite = new TipoTramite();
            tipoTramite.setId_tipo_tramite(2);
         
            Tramite tram = new Tramite();
            tram.setId_tramite(ouput.getTramie().getId_tramite());
            tram.setInfor_Discapacitado(info_return);
            Usuario usuario= new Usuario() ;
            usuario.setId_Usuario(1);
            tram.setUsuario(usuario);
            tram.setTipoTramite(tipoTramite);
            tram.setImg_solicitud(obtenerImagen(hoja1));
            Tramite tramite_Return = servicioTramite.modificar(tramite);
            
            
        } catch (Exception e) {
            System.out.println(e);
        }

        return "redirect:/modificarTramiteProgramaContigo/"+id;
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
