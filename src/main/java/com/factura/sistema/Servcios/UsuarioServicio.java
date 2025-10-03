package com.factura.sistema.Servcios;

import java.util.List;

import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.factura.sistema.Entidades.Usuario;
import com.factura.sistema.Repositorios.UsuarioRepositorio;

@Service
public class UsuarioServicio {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    @Lazy
    private PasswordEncoder passwordEncoder;

    public Usuario guardar(Usuario usuario){
         usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioRepositorio.save(usuario);

    }
    public List<Usuario> ListarAll(){
        return usuarioRepositorio.findAll();
    }
    public Usuario listUsuarioNombre(String username){
        return usuarioRepositorio.findByUsername(username).orElse(null);
    }
    public Usuario ListarUsuario(Long id){
        return usuarioRepositorio.findById(id).orElse(null);
    }
    public void eliminar(Long id){
        usuarioRepositorio.deleteById(id);
    }
}
