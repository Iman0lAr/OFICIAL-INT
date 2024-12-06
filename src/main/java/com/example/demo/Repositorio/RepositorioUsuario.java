
package com.example.demo.Repositorio;


import com.example.demo.Entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, Integer>{
    
    @Query(value = "CALL usp_Inicio_Sesion(:uss,:contra)", nativeQuery = true)
    Usuario InicioSesion(@Param("uss") String uss,@Param("contra") String contra);
    
     @Query(value = "CALL usp_actualizarPasword_update (:username,:newPassword)", nativeQuery = true)
    Usuario modificarPassword(@Param("username") String username,@Param("newPassword") String newPassword);
    
    @Query(value = "CALL usp_Crear_Usuario(:new_usuario,:new_password,:tipo_uss,:codigo_persona,:codigoUsuarioCreador)", nativeQuery = true)
    Usuario CrearUsario(
            @Param("new_usuario") String new_usuario,
            @Param("new_password") String new_password,
            @Param("tipo_uss") String tipo_uss,
            @Param("codigo_persona") Integer codigo_persona,
            @Param("codigoUsuarioCreador") Integer codigoUsuarioCreador);
    
    @Query(value = "select * from tb_usuario tu  where tu.usuario =?1", nativeQuery = true)
    Usuario buscarPorUsername (String usuario);
    
}
