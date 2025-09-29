package com.factura.sistema.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.factura.sistema.Entidades.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario,Long>{

    
} 
