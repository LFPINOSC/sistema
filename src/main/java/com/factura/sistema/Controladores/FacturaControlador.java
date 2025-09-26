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

import com.factura.sistema.Entidades.Factura;
import com.factura.sistema.Servcios.FacturaServicio;

@RestController
@RequestMapping("/api/factura")
public class FacturaControlador {
    @Autowired
    private FacturaServicio facturaServicio;

    @PostMapping
    public Factura crear(@RequestBody Factura factura){
        return facturaServicio.guardar(factura);
    }
    @PutMapping 
    public Factura actualizar(@RequestBody Factura factura, @PathVariable Long id){
        factura.setId(id);
        return facturaServicio.guardar(factura);
    }
    @GetMapping 
    public List<Factura> Listar(){
        return facturaServicio.listaAll();
    }
    @GetMapping("/{id}")
    public Factura obtener(@PathVariable Long id){
        return facturaServicio.listaFactura(id);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        facturaServicio.eliminar(id);
    }
}
