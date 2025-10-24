package com.factura.sistema.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.factura.sistema.Entidades.Noticia;

@Repository
public interface NoticiaRepositorio extends JpaRepository<Noticia, Long>{
    
}
