package com.example.demo.Controladores;

import ClasesFormulario.FormCarnet;
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
import com.example.demo.Entidades.TipoTramite;
import com.example.demo.Entidades.Tramite;
import com.example.demo.Entidades.Usuario;
import com.example.demo.Servicios.ServicioCertificadoDeDiscapacidad;
import com.example.demo.Servicios.ServicioDireccion;
import com.example.demo.Servicios.ServicioDiscapacitado;
import com.example.demo.Servicios.ServicioInfoDiscapacitado;
import com.example.demo.Servicios.ServicioPersona;
import com.example.demo.Servicios.ServicioRepresentante;
import com.example.demo.Servicios.ServicioTramite;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import java.io.IOException;
import java.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ControllerPrueba {

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

    @GetMapping("/tramite")
    public String tramiteCarnet(Model model, HttpSession session) {
        if (session.getAttribute("uss") == null) {
            return "redirect:/home";
        }
        Usuario usuario=(Usuario) session.getAttribute("uss");
        System.out.println(usuario.getTipoUsuario().getId_tipo_usuario());
        boolean conf = false; // Valor predeterminado
        if (model.containsAttribute("confirmacion")) {
            conf = (boolean) model.getAttribute("confirmacion"); // Obtener el valor de confirmacion
        }
        model.addAttribute("confirmacion", conf);
        model.addAttribute("formcarnet", new FormCarnet());
        return "TramiteCarnet";
    }
    
    @Transactional
    @PostMapping("/tramiteCarnet")
    public String guardarTramite(@ModelAttribute("formcarnet") FormCarnet formcarnet, RedirectAttributes redirectAttributes, Model model,
            @RequestParam(value = "copiaDniDis", required = false) MultipartFile file,
            @RequestParam(value = "copiaDniRepre", required = false) MultipartFile file2,
            @RequestParam(value = "copiaCerPart1", required = false) MultipartFile file3,
            @RequestParam(value = "copiaCerPart2", required = false) MultipartFile file4,
            @RequestParam(value = "copiaSolicitud", required = false) MultipartFile file5,
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

            redirectAttributes.addFlashAttribute("successMessage", "Trámite guardado correctamente.");

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

            Direccion direc_Dis = servicioDireccion.guardar(direccion);

            Persona persona_Repre = formcarnet.getPersona_repre();
            persona_Repre.setDocumentoDeIdentidad(formcarnet.getDocumentoDeIdentidad_repre());

            Sexo sexoRepre = formcarnet.getSexo_repre();

            persona_Repre.setSexo(sexoRepre);

            redirectAttributes.addFlashAttribute("successMessage", "Trámite guardado correctamente.");

            Departamento departamento_Repre = formcarnet.getDepartamento_Repre();
            Provincia provincia_Repre = formcarnet.getProvincia_Repre();

            provincia_Repre.setDepartamento(departamento_Repre);
            Distrito distrito_Repre = formcarnet.getDistrito_Repre();
            distrito_Repre.setProvincia(provincia_Repre);

            Direccion direcccion_Repre = formcarnet.getDireccion_Repre();
            direcccion_Repre.setDistrito(distrito_Repre);

            direcccion_Repre.setPersona(persona_Repre);

            Direccion direc_Repre = servicioDireccion.guardar(direcccion_Repre);

            Discapacitado disc_return = servicioDiscapacitado.guardar(direc_Dis, obtenerImagen(file));

            // Si el archivo es nulo o está vacío, se inserta NULL en la base de datos
            Representante repre = new Representante();

            repre.setCopia_dni(obtenerImagen(file2));
            Representante represen = servicioRepresentante.guardar((direc_Repre == null) ? null : direc_Repre.getPersona().getId_persona(), disc_return.getId_discapacitado(), repre.getCopia_dni());

            CertificadoDeDiscapacidad certificadoDeDiscapacidad = formcarnet.getCertificadoDeDiscapacidad();
            certificadoDeDiscapacidad.setDiscapacitado(disc_return);

            certificadoDeDiscapacidad.setCopia_cert1(obtenerImagen(file3)); // Convierte el archivo en un arreglo de bytes
            certificadoDeDiscapacidad.setCopia_cert2(obtenerImagen(file4));

            CertificadoDeDiscapacidad cer_return = serviciocertificado.guardar(certificadoDeDiscapacidad);

            Infor_Discapacitado infor_Discapacitado = new Infor_Discapacitado();
            infor_Discapacitado.setDiscapacitado(disc_return);
            infor_Discapacitado.setRepresentante(represen);
            infor_Discapacitado.setCertificadoDeDiscapacidad(cer_return);
            infor_Discapacitado.setDireccion(direc_Dis);
            infor_Discapacitado.setDireccion_repre(direc_Repre);
            
            Infor_Discapacitado info_return = ServicioInfoDiscapacitado.guardar(infor_Discapacitado, represen == null);

            TipoTramite tipoTramite = new TipoTramite();
            tipoTramite.setNom_tipo_tramite("Cartnet conadis");
            Contacto contacto = formcarnet.getContacto();
           /* Usuario usuario = new Usuario();
            usuario.setId_Usuario(1);*/
            Tramite tramite = new Tramite();
            tramite.setInfor_Discapacitado(info_return);
            tramite.setContacto(contacto);
            tramite.setUsuario(usuario);
            tramite.setTipoTramite(tipoTramite);

            tramite.setImg_solicitud(obtenerImagen(file5));
            Tramite tramite_Return = ServicioTramite.guardar(tramite);
            redirectAttributes.addFlashAttribute("confirmacion", true);
        } catch (Exception e) {
            System.out.println(e);
            redirectAttributes.addFlashAttribute("errorMessage", "Ocurrió un error al guardar el trámite.");
        } finally {
            model.addAttribute("formcarnet", new FormCarnet());
            return "redirect:/tramite";
        }
    }

    private byte[] obtenerImagen(MultipartFile file) throws IOException {
        if (file == null || file.isEmpty()) {
            return null;
        }
        return file.getBytes();
    }

    @GetMapping("/DniDisc")
    public String mostrarFoto(Model model) throws Exception {

        Tramite discapacitad = ServicioTramite.buscarId(18);
        Discapacitado discapacitado= servicioDiscapacitado.buscarId(1);
        Representante repre=servicioRepresentante.buscarId(12);
        String fotoBase64 = convertirImagenAStringBase64(repre.getCopia_dni());

        model.addAttribute("foto", fotoBase64);

        return "mostrarFoto";
    }

    private String convertirImagenAStringBase64(byte[] foto) throws IOException {
        return Base64.getEncoder().encodeToString(foto);
    }

}
