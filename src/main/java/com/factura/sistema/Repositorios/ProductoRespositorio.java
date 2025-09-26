package com.factura.sistema.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.factura.sistema.Entidades.Producto;

public interface ProductoRespositorio extends JpaRepository<Producto, Long>{
    
}
