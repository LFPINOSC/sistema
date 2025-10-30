package com.factura.sistema.Servcios;



import org.springframework.stereotype.Service;

import com.factura.sistema.Entidades.PiePagina;
import com.factura.sistema.Repositorios.PiePaginaRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class PiePaginaServicio {

    @Autowired
    private PiePaginaRepositorio repositorio;

    public List<PiePagina> listar() {
        return repositorio.findAll();
    }

    public PiePagina obtenerPorId(Long id) {
        return repositorio.findById(id).orElse(null);
    }

    public PiePagina guardar(PiePagina piePagina) {
        return repositorio.save(piePagina);
    }

    public void eliminar(Long id) {
        repositorio.deleteById(id);
    }
}

