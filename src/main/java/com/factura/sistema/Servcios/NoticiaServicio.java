package com.factura.sistema.Servcios;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.factura.sistema.Entidades.Noticia;
import com.factura.sistema.Repositorios.NoticiaRepositorio;

import jakarta.transaction.Transactional;

@Service
public class NoticiaServicio {
    @Autowired
    private NoticiaRepositorio noticiaRepositorio;
    @Transactional
    public Noticia guardar(Noticia noticia){
        return noticiaRepositorio.save(noticia);
    }
    
    public List<Noticia> listaAll(){
        return noticiaRepositorio.findAll();
    }
    public Noticia listaNoticia(Long id){
        return noticiaRepositorio.findById(id).orElse(null);
    }
    public void eliminar(Long id){
        noticiaRepositorio.deleteById(id);
    }
}
