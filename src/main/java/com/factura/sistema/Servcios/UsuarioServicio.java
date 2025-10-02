package com.factura.sistema.Servcios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.factura.sistema.Entidades.Usuario;
import com.factura.sistema.Repositorios.UsuarioRepositorio;

@Service
public class UsuarioServicio {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public Usuario guardar(Usuario usuario){
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
