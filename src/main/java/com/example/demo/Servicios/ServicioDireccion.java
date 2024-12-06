package com.example.demo.Servicios;

import com.example.demo.Entidades.Direccion;
import com.example.demo.Entidades.Discapacitado;
import com.example.demo.Repositorio.RepositorioDireccion;
import com.example.demo.Repositorio.RepositorioDiscapacitado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioDireccion {

    @Autowired
    private RepositorioDireccion repositorioDireccion;

    public Direccion guardar(Direccion discapacitado) {
        try {
            if (!discapacitado.getPersona().getDocumentoDeIdentidad().getNro_documento().isEmpty()) {
                return repositorioDireccion.insertar(
                        discapacitado.getPersona().getNombre(),
                        discapacitado.getPersona().getApell_paterno(),
                        discapacitado.getPersona().getApell_materno(),
                        discapacitado.getPersona().getDocumentoDeIdentidad().getNro_documento(),
                        discapacitado.getPersona().getSexo().getNom_sexo(),
                        discapacitado.getDistrito().getNom_distrito(),
                        discapacitado.getDistrito().getProvincia().getNom_ciudad(),
                        discapacitado.getDistrito().getProvincia().getDepartamento().getNom_departamento(),
                        discapacitado.getCalle());
            }
        } catch (Exception e) {
            e.printStackTrace(); // O usa un logger para registrar el error
        }
        return null;
    }

    public Direccion buscar(Integer id) {
        return repositorioDireccion.findById(id).orElse(null);
    }

    public Direccion guardarPC(Direccion discapacitado) {
        try {
            if (!discapacitado.getPersona().getDocumentoDeIdentidad().getNro_documento().isEmpty()) {

                return repositorioDireccion.insertarPC(
                        discapacitado.getPersona().getNombre(),
                        discapacitado.getPersona().getApell_paterno(),
                        discapacitado.getPersona().getApell_materno(),
                        discapacitado.getPersona().getDocumentoDeIdentidad().getNro_documento(),
                        discapacitado.getPersona().getSexo().getNom_sexo(),
                        discapacitado.getDistrito().getNom_distrito(),
                        discapacitado.getDistrito().getProvincia().getNom_ciudad(),
                        discapacitado.getDistrito().getProvincia().getDepartamento().getNom_departamento(),
                        discapacitado.getCalle(),
                        discapacitado.getRef_direccion(),
                        discapacitado.getCentroPoblado()
                );
            }
        } catch (Exception e) {
            e.printStackTrace(); // O usa un logger para registrar el error
        }
        return null;
    }

    
    
}
