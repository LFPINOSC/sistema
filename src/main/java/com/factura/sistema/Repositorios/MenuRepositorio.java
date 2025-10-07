package com.factura.sistema.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.factura.sistema.Entidades.Menu;
@Repository
public interface MenuRepositorio extends JpaRepository<Menu,Long> {
    
}
