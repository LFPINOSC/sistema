package com.factura.sistema.Repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.factura.sistema.Entidades.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario,Long>{
    Optional<Usuario> findByUsername(String username);
    boolean existsByUsername(String username);
} 
