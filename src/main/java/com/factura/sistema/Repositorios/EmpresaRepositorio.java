package com.factura.sistema.Repositorios;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.factura.sistema.Entidades.Empresa;

import java.util.Optional;

@Repository
public interface EmpresaRepositorio extends JpaRepository<Empresa, Long> {

    Optional<Empresa> findByActivaTrue();
    @Modifying
    @Query("UPDATE Empresa e SET e.activa = false WHERE e.activa = true")
    void desactivarTodas();
}

