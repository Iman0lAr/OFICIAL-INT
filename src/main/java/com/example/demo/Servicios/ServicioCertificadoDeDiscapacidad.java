package com.example.demo.Servicios;

import com.example.demo.Entidades.CertificadoDeDiscapacidad;
import com.example.demo.Repositorio.RepositorioCertificadoDeDiscapacidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioCertificadoDeDiscapacidad {

    @Autowired
    private RepositorioCertificadoDeDiscapacidad repositorioCertificadoDeDiscapacidad;

    public CertificadoDeDiscapacidad guardar(CertificadoDeDiscapacidad certificadoDeDiscapacidad) {
        try {
            return repositorioCertificadoDeDiscapacidad.insertarCertificadoDeDiscapacidad(
                    certificadoDeDiscapacidad.getFecha_emision(),
                    certificadoDeDiscapacidad.getNum_certificado(),
                    certificadoDeDiscapacidad.getDiscapacitado().getId_discapacitado(),
                    certificadoDeDiscapacidad.getCopia_cert1(),
                    certificadoDeDiscapacidad.getCopia_cert2()
            );
        } catch (Exception e) {
            e.printStackTrace(); // O usa un logger para registrar el error
        }
        return null;
    }
    
    public CertificadoDeDiscapacidad buscarId(Integer id){
        return repositorioCertificadoDeDiscapacidad.findById(id).orElse(null);
    }
    
    public CertificadoDeDiscapacidad obtenerCertificadoDeDiscapacidad(Integer id_certificado){
        return repositorioCertificadoDeDiscapacidad.obtenerCer_Dis_Perso(id_certificado);
    }
    
    public CertificadoDeDiscapacidad modificarCertificadoDeDiscapacidad(CertificadoDeDiscapacidad certificado){
        return repositorioCertificadoDeDiscapacidad.save(certificado);
    }
}
