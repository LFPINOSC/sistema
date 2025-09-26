package com.factura.sistema.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.factura.sistema.Entidades.Factura;

public interface FacturaRepositorio extends JpaRepository<Factura, Long> {
    
}
