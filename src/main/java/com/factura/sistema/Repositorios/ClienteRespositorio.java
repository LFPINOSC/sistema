package com.factura.sistema.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.factura.sistema.Entidades.Cliente;
@Repository
public interface ClienteRespositorio extends JpaRepository<Cliente, Long>{
    
}
