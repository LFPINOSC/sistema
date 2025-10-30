package com.factura.sistema.Controladores;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.factura.sistema.Entidades.PiePagina;
import com.factura.sistema.Servcios.PiePaginaServicio;

import java.util.List;

@RestController
@RequestMapping("/api/pie-pagina")
@CrossOrigin(origins = "*")
public class PiePaginaControlador {

    @Autowired
    private PiePaginaServicio servicio;

    @GetMapping
    public List<PiePagina> listar() {
        return servicio.listar();
    }

    @GetMapping("/{id}")
    public PiePagina obtener(@PathVariable Long id) {
        return servicio.obtenerPorId(id);
    }

    @PostMapping
    public PiePagina crear(@RequestBody PiePagina piePagina) {
        return servicio.guardar(piePagina);
    }

    @PutMapping("/{id}")
    public PiePagina actualizar(@PathVariable Long id, @RequestBody PiePagina piePagina) {
        piePagina.setId(id);
        return servicio.guardar(piePagina);
    }
}
