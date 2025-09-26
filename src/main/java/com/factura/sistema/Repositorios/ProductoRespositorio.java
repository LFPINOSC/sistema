package com.factura.sistema.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.factura.sistema.Entidades.Producto;

@Repository
public interface ProductoRespositorio extends JpaRepository<Producto, Long>{
    
}
