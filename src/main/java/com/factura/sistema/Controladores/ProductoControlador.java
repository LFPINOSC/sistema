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

import com.factura.sistema.Entidades.Producto;
import com.factura.sistema.Servcios.ProductoServicio;

@RestController
@RequestMapping("/api/producto")
public class ProductoControlador {
    @Autowired
    private ProductoServicio productoServicio;

    @PostMapping
    public Producto crear(@RequestBody Producto producto){
        return productoServicio.guardar(producto);
    }
    @PutMapping("/{id}")
    public Producto actualizar(@RequestBody Producto producto, @PathVariable Long id){
        producto.setId(id);
        return productoServicio.guardar(producto);
    }
    @GetMapping
    public List<Producto> listar(){
        return productoServicio.listaAll();
    }
    @GetMapping("/{id}")
    public Producto obtener(@PathVariable Long id){
        return productoServicio.listaProducto(id);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        productoServicio.eliminar(id);
    }
}
