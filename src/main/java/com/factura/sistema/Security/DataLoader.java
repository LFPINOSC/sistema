package com.factura.sistema.Security;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.factura.sistema.Entidades.TipoUsuario;
import com.factura.sistema.Entidades.Usuario;
import com.factura.sistema.Repositorios.TipoUsuarioRepositorio;
import com.factura.sistema.Servcios.UsuarioServicio;

@Configuration
public class DataLoader {
    @Bean
    CommandLineRunner initData(TipoUsuarioRepositorio tipoUsuarioRepositorio, UsuarioServicio usuarioServicio){
        return args ->{
            if(!tipoUsuarioRepositorio.findAll().iterator().hasNext()){
                TipoUsuario tipoUsuario=new TipoUsuario();
                tipoUsuario.setDescripcion("administrador");
                tipoUsuario.setNombre("administrador");
                tipoUsuarioRepositorio.save(tipoUsuario);
                TipoUsuario tipoUsuario1=new TipoUsuario();
                tipoUsuario1.setDescripcion("gerente");
                tipoUsuario1.setNombre("gerente");
                tipoUsuarioRepositorio.save(tipoUsuario1);

                Usuario usuario =new Usuario();
                usuario.setApellido("admin");
                usuario.setNombre("admin");
                usuario.setUsername("admin");
                usuario.setPassword("admin");
                usuario.setTipoUsuario(tipoUsuario);
                usuarioServicio.guardar(usuario);

                

            }
        };
    }
}
