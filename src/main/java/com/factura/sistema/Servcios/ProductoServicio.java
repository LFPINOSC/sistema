package com.factura.sistema.Servcios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.factura.sistema.Entidades.Producto;
 import com.factura.sistema.Repositorios.ProductoRespositorio;


public class ProductoServicio {
    @Autowired
    private ProductoRespositorio productoRespositorio;

    public Producto guardar(Producto producto){
        return productoRespositorio.save(producto);
    }
    public List<Producto> listaAll(){
        return productoRespositorio.findAll();
    }
    public Producto listaProducto(Long id){
        return productoRespositorio.findById(id).orElse(null);
    }
    public void eliminar(Long id){
        productoRespositorio.deleteById(id);
    }
}
