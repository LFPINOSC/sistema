package com.factura.sistema.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.factura.sistema.Entidades.Cliente;

public interface ClienteRespositorio extends JpaRepository<Cliente, Long>{
    
}
