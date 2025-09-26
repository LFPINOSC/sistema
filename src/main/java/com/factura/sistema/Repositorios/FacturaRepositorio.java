package com.factura.sistema.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.factura.sistema.Entidades.Factura;
@Repository
public interface FacturaRepositorio extends JpaRepository<Factura, Long> {
    
}
