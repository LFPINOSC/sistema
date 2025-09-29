package com.factura.sistema.Servcios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.factura.sistema.Entidades.TipoUsuario;
import com.factura.sistema.Repositorios.TipoUsuarioRepositorio;

@Service
public class TipoUsuarioServicio {
    @Autowired
    private TipoUsuarioRepositorio tipoUsuarioRepositorio;

    public TipoUsuario guardar(TipoUsuario tipoUsuario){
        return tipoUsuarioRepositorio.save(tipoUsuario);
    }
    public List<TipoUsuario> ListaAll(){
        return tipoUsuarioRepositorio.findAll();
    }
    public TipoUsuario ListaTipoUsuario(Long id){
        return tipoUsuarioRepositorio.findById(id).orElse(null);
    }
    public void eliminar(Long id){
        tipoUsuarioRepositorio.deleteById(id);
    }
    
}
