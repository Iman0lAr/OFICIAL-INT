package com.example.demo.Controladores;

import ClasesFormulario.FormCarnet;
import com.example.demo.Entidades.CertificadoDeDiscapacidad;
import com.example.demo.Entidades.Contacto;
import com.example.demo.Entidades.Departamento;
import com.example.demo.Entidades.Direccion;
import com.example.demo.Entidades.Discapacitado;
import com.example.demo.Entidades.Distrito;
import com.example.demo.Entidades.DocumentoDeIdentidad;
import com.example.demo.Entidades.Estudios;
import com.example.demo.Entidades.Infor_Discapacitado;
import com.example.demo.Entidades.Persona;
import com.example.demo.Entidades.Provincia;
import com.example.demo.Entidades.Representante;
import com.example.demo.Entidades.Sexo;
import com.example.demo.Entidades.TipoTramite;
import com.example.demo.Entidades.Tramite;
import com.example.demo.Entidades.Usuario;
import com.example.demo.Servicios.ServicioCertificadoDeDiscapacidad;
import com.example.demo.Servicios.ServicioDireccion;
import com.example.demo.Servicios.ServicioDiscapacitado;
import com.example.demo.Servicios.ServicioInfoDiscapacitado;
import com.example.demo.Servicios.ServicioNivelEstudios;
import com.example.demo.Servicios.ServicioPersona;
import com.example.demo.Servicios.ServicioRepresentante;
import com.example.demo.Servicios.ServicioTipoRelacion;
import com.example.demo.Servicios.ServicioTramite;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ControllerFormPC {

    
    
     @Autowired
    private ServicioPersona servicioPersona;
    @Autowired
    private ServicioDireccion servicioDireccion;

    @Autowired
    private ServicioDiscapacitado servicioDiscapacitado;

    @Autowired
    private ServicioCertificadoDeDiscapacidad serviciocertificado;

    @Autowired
    private ServicioRepresentante servicioRepresentante;

    @Autowired
    private ServicioInfoDiscapacitado ServicioInfoDiscapacitado;

    @Autowired
    private ServicioTramite ServicioTramite;
    
    @Autowired
    private ServicioTipoRelacion  servicioTipoRelacion ;
    
    @Autowired
    private ServicioNivelEstudios servicioNivelEstudios;
    
    @GetMapping("/tramitePC")
    public String mostrarFormPc(HttpSession sesion, Model model) {
        if (sesion.getAttribute("uss") == null) {
            return "redirect:/index";
        }
        model.addAttribute("claseForm", new FormCarnet());
        model.addAttribute("parentescos",new ArrayList<>(servicioTipoRelacion.findAll()));
        model.addAttribute("nivelEstudios",new ArrayList<>(servicioNivelEstudios.findAll()));
        return "FormProgramaContigo";
    }

    
    @Transactional
    @PostMapping("/guardarProgramaContigo")
    public String guardarTramite(
            @ModelAttribute(name = "claseForm") FormCarnet formcarnet,
            @RequestParam(name = "autoPersepcion") String autoPersepcion,
            @RequestParam(name = "nivelEstudio") String nivelEstudio,
            @RequestParam(value = "copiaCerPart2", required = false) MultipartFile copiaCerPart2,
            @RequestParam(value = "copiaCerPart1", required = false) MultipartFile copiaCerPart1,
            @RequestParam(value = "parentesco",required = false) String parentesco,
            @RequestParam(value = "hoja1", required = false) MultipartFile hoja1,
            @RequestParam(value = "hoja2", required = false) MultipartFile hoja2,
            HttpSession httpSession
            ) {

        try {
            
            Usuario usuario=(Usuario) httpSession.getAttribute("uss");
            
            Persona persona = new Persona();
            DocumentoDeIdentidad documentoDeIdentidad = new DocumentoDeIdentidad();
            documentoDeIdentidad.setNro_documento(formcarnet.getDocumentoDeIdentidad().getNro_documento());
            persona.setDocumentoDeIdentidad(documentoDeIdentidad);

            persona.setNombre(formcarnet.getPersona_dis().getNombre());
            persona.setApell_paterno(formcarnet.getPersona_dis().getApell_paterno());
            persona.setApell_materno(formcarnet.getPersona_dis().getApell_materno());

            Sexo sexo = new Sexo();
            sexo.setNom_sexo(formcarnet.getSexo().getNom_sexo());
            persona.setSexo(sexo);

          //  redirectAttributes.addFlashAttribute("successMessage", "Trámite guardado correctamente.");

            Departamento departamento = new Departamento(formcarnet.getDepartamento().getNom_departamento());
            Provincia provincia = new Provincia();
            provincia.setNom_ciudad(formcarnet.getProvincia().getNom_ciudad());
            provincia.setDepartamento(departamento);
            Distrito distrito = new Distrito();
            distrito.setNom_distrito(formcarnet.getDistrito().getNom_distrito());
            distrito.setProvincia(provincia);

            Direccion direccion = new Direccion();
            direccion.setDistrito(distrito);

            direccion.setCalle(formcarnet.getDireccion().getCalle());
            direccion.setPersona(persona);
            direccion.setRef_direccion(formcarnet.getDireccion().getRef_direccion());
            direccion.setCentroPoblado(formcarnet.getDireccion().getCentroPoblado());
            
            Direccion direc_Dis = servicioDireccion.guardarPC(direccion);
            System.out.println(direc_Dis.getPersona().getId_persona());
            Persona persona_Repre = formcarnet.getPersona_repre();
            persona_Repre.setDocumentoDeIdentidad(formcarnet.getDocumentoDeIdentidad_repre());

            Sexo sexoRepre = formcarnet.getSexo_repre();
            formcarnet.getDiscapacitado().setAutopercepcion(autoPersepcion);
            persona_Repre.setSexo(sexoRepre);

            System.out.println(autoPersepcion);
            Persona personaReprereturn = servicioPersona.insertarPersonaRepresentante(persona_Repre);

            Discapacitado disc_return =servicioDiscapacitado.insertDiscPc(direc_Dis.getPersona().getId_persona(), formcarnet.getDiscapacitado(), formcarnet.getDiscapacitado().getEstudios().getDesc_estudios(),Integer.parseInt(nivelEstudio));

             Representante represen=null;
             if(!formcarnet.getPersona_repre().getNombre().trim().isEmpty()){   
                 represen= servicioRepresentante.insertarRepresentantePc(formcarnet.getRepresentante(), personaReprereturn.getId_persona(), disc_return.getId_discapacitado(), Integer.parseInt(parentesco));
             }
      
            CertificadoDeDiscapacidad certificadoDeDiscapacidad = formcarnet.getCertificadoDeDiscapacidad();
            certificadoDeDiscapacidad.setDiscapacitado(disc_return);

            certificadoDeDiscapacidad.setCopia_cert1( copiaCerPart1==null? null: obtenerImagen(copiaCerPart1)); // Convierte el archivo en un arreglo de bytes
            certificadoDeDiscapacidad.setCopia_cert2( copiaCerPart2==null? null:obtenerImagen(copiaCerPart2));

            CertificadoDeDiscapacidad cer_return = serviciocertificado.guardar(certificadoDeDiscapacidad);

            Infor_Discapacitado infor_Discapacitado = new Infor_Discapacitado();
            infor_Discapacitado.setDiscapacitado(disc_return);
            infor_Discapacitado.setRepresentante(represen);
            infor_Discapacitado.setCertificadoDeDiscapacidad(cer_return);
            infor_Discapacitado.setDireccion(direc_Dis);
            infor_Discapacitado.setDireccion_repre(null);
            
            Infor_Discapacitado info_return = ServicioInfoDiscapacitado.guardarInfoPc(infor_Discapacitado, true);

            TipoTramite tipoTramite = new TipoTramite();
            tipoTramite.setId_tipo_tramite(2);
         
            Tramite tramite = new Tramite();
            tramite.setInfor_Discapacitado(info_return);
            tramite.setUsuario(usuario);
            tramite.setTipoTramite(tipoTramite);

            tramite.setImg_solicitud(obtenerImagen(hoja1));
            Tramite tramite_Return = ServicioTramite.guardarTramitePC(tramite);
           // redirectAttributes.addFlashAttribute("confirmacion", true);
        } catch (Exception e) {
            System.out.println(e);
            //redirectAttributes.addFlashAttribute("errorMessage", "Ocurrió un error al guardar el trámite.");
        } finally {
          //  model.addAttribute("formcarnet", new FormCarnet());
           return "redirect:/tramitePC";
        }
    }

     private byte[] obtenerImagen(MultipartFile file) throws IOException {
        if (file == null || file.isEmpty()) {
            return null;
        }
        return file.getBytes();
    }
    
}
