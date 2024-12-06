package com.example.demo.Controladores;

import com.example.demo.Entidades.DocumentoDeIdentidad;
import com.example.demo.Entidades.Persona;
import com.example.demo.Entidades.Usuario;
import com.example.demo.Servicios.ServicioPersona;
import com.example.demo.Servicios.ServicioUsuario;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ControllerCreacionnDeUsuario {

    @Autowired
    private ServicioPersona servicioPersona;

    @Autowired
    private ServicioUsuario servicioUsuario;

    @GetMapping("/GestionarUsuarios")
    public String mostrarVista(Model model, HttpSession session) {
      
        if (session.getAttribute("uss") == null) {
            return "redirect:/home";
        }
        
        Usuario uss=(Usuario) session.getAttribute("uss");
        if(uss.getTipoUsuario().getId_tipo_usuario()!=1){
            return "redirect:/home";
        }
        Boolean tiene_cuenta = false;
        Boolean mostrar_Mo = false;
        Boolean conf_creacion=false;
        
        if (model.containsAttribute("t_cuenta")) {
            tiene_cuenta = (Boolean) model.getAttribute("t_cuenta");
        }

        if (model.containsAttribute("mostrar_modal")) {
            mostrar_Mo = (Boolean) model.getAttribute("mostrar_modal");
        }
        
        if(model.containsAttribute("conf_creacion")){
            conf_creacion=(Boolean) model.getAttribute("conf_creacion");
        }
        
        
        Persona persona= new Persona();
        if(model.containsAttribute("datos")){
           Persona per= (Persona) model.getAttribute("datos");
           persona.setNombre(per.getNombre());
           persona.setApell_paterno(per.getApell_paterno());
           persona.setApell_materno(per.getApell_materno());
           Usuario us=new Usuario();
           persona.setUsuario(per.getUsuario());
            DocumentoDeIdentidad doc=new DocumentoDeIdentidad();
            doc.setNro_documento(per.getDocumentoDeIdentidad().getNro_documento());
           persona.setDocumentoDeIdentidad(doc);
        }

        ArrayList<Usuario> usarios= new ArrayList<>(servicioUsuario.obtenerUsuarios());
        Usuario usuarioUpdate=new Usuario();
        
       
        model.addAttribute("persona", persona);
        model.addAttribute("t_cuenta", tiene_cuenta);
        model.addAttribute("mostrar_modal", mostrar_Mo);
        model.addAttribute("conf_creacion", conf_creacion);
        model.addAttribute("usuarios", usarios);
        model.addAttribute("usuarioUpdate", usuarioUpdate);
        
        return "CrearUsuario";
    }

    
    @Transactional
    @PostMapping("/AgregarUsuario")
    public String agregar(@ModelAttribute(name = "persona") Persona persona,
            @RequestParam("tipo_uss") String tipo_uss,
            Model model,
            RedirectAttributes redirectAttributes,
            HttpSession httpSession) {

        Boolean cuenta_Tiene = false;
        Boolean conf_creacion=false;
        
     
        Usuario usuario=(Usuario) httpSession.getAttribute("uss");
 
        Persona per_return = servicioPersona.InsertarPersona_U(persona);
        Usuario usu_return = null;
       
        if (per_return.getUsuario() != null) {
            cuenta_Tiene = true;
        } else {
            conf_creacion=true;
            usu_return = servicioUsuario.CrearUsuario(persona.getUsuario(), tipo_uss,per_return.getId_persona(),usuario.getId_Usuario());
            per_return.setUsuario(usu_return);
        }
        
        
        
        Boolean mostrarM = true;
        
        redirectAttributes.addFlashAttribute("datos", per_return);
        redirectAttributes.addFlashAttribute("t_cuenta", cuenta_Tiene); 
        redirectAttributes.addFlashAttribute("mostrar_modal", mostrarM);  
        redirectAttributes.addFlashAttribute("conf_creacion", conf_creacion);
    
        return "redirect:/GestionarUsuarios"; 
    }

    @Transactional
    @PostMapping("/modificarUsuario")
    public String modificar(@ModelAttribute(name = "usuarioUpdate") Usuario usuarioUpdate){
       try{ 
        Usuario usuario = servicioUsuario.modificarUsuario(usuarioUpdate.getUsuario(), usuarioUpdate.getContraseña());
        if(usuario==null){
            throw new Exception();
        }
       }catch(Exception e){
       }
       return "redirect:/GestionarUsuarios"; 
    }
     @PostMapping("/modificarEstado")
     public String modificarEstado(@RequestParam(name = "username")  String username){
     
         Usuario usuariExist= servicioUsuario.buscarPorUsername(username);
      
         if(usuariExist.getEstado()){
             usuariExist.setEstado(Boolean.FALSE);
         }else{
             usuariExist.setEstado(Boolean.TRUE);
         }
         Usuario usuarioUpdate=servicioUsuario.guardar(usuariExist);
  
         return "redirect:/GestionarUsuarios"; 
     }
}
