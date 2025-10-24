package com.factura.sistema.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.factura.sistema.Entidades.Noticia;
import com.factura.sistema.Servcios.NoticiaServicio;
@RestController
@RequestMapping("/api/noticia")
public class NoticiaControlador {
    @Autowired 
    private NoticiaServicio noticiaServicio;

    @PostMapping
    public Noticia crear(@RequestBody Noticia noticia){
        System.out.println(noticia);
        return noticiaServicio.guardar(noticia);
    }
    @PutMapping("/{id}")
    public Noticia actualizar(@RequestBody Noticia noticia, @PathVariable Long id){
        noticia.setId(id);
        return noticiaServicio.guardar(noticia);
    }
    @GetMapping
    public List<Noticia> listar(){
        return noticiaServicio.listaAll();
    }
    @GetMapping("/{id}")
    public Noticia obtener(@PathVariable Long id){
        return noticiaServicio.listaNoticia(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        noticiaServicio.eliminar(id);
    }
}
