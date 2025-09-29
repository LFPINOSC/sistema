package com.factura.sistema.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.factura.sistema.Entidades.TipoUsuario;
import com.factura.sistema.Servcios.TipoUsuarioServicio;

@Controller
@RestController
@RequestMapping("/api/tipousuario")
public class TipoUsuarioControlador {
    @Autowired
    private TipoUsuarioServicio tipoUsuarioServicio;

    @PostMapping
    private TipoUsuario crear(@RequestBody TipoUsuario tipoUsuario){
        return tipoUsuarioServicio.guardar(tipoUsuario);
    }
    
    @PutMapping 
    private TipoUsuario actualizar(@RequestBody TipoUsuario tipoUsuario, @PathVariable Long id){
        tipoUsuario.setId(id);
        return tipoUsuarioServicio.guardar(tipoUsuario);
    }
    @GetMapping
    private List<TipoUsuario> listar(){
        return tipoUsuarioServicio.ListaAll();
    }
    @GetMapping("/{id}")
    private TipoUsuario obtener(@PathVariable Long id){
       return tipoUsuarioServicio.ListaTipoUsuario(id);
    }
    
    @DeleteMapping("/{id}")
    private void eliminar(@PathVariable Long id){
        tipoUsuarioServicio.eliminar(id);
    }
}
