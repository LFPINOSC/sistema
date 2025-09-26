package com.factura.sistema.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.factura.sistema.Entidades.DetFactura;
@Repository
public interface DetFacturaRepositorio extends JpaRepository<DetFactura,Long>{
    
}
