package com.factura.sistema.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.factura.sistema.Entidades.DetFactura;

public interface DetFacturaRepositorio extends JpaRepository<DetFactura,Long>{
    
}
