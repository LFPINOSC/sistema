package com.factura.sistema.Servcios;



import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.factura.sistema.Entidades.Empresa;
import com.factura.sistema.Repositorios.EmpresaRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepositorio empresaRepository;

    public List<Empresa> listar() {
        return empresaRepository.findAll();
    }

    public Optional<Empresa> obtenerPorId(Long id) {
        return empresaRepository.findById(id);
    }

    public Optional<Empresa> obtenerActiva() {
        return empresaRepository.findByActivaTrue();
    }

    @Transactional
    public Empresa crear(Empresa empresa) {
        if (empresa.isActiva()) {
            empresaRepository.desactivarTodas();
        }
        return empresaRepository.save(empresa);
    }

    @Transactional
    public Optional<Empresa> actualizar(Long id, Empresa empresaDatos) {
        return empresaRepository.findById(id).map(empresa -> {
            empresa.setNombre(empresaDatos.getNombre());
            empresa.setMision(empresaDatos.getMision());
            empresa.setVision(empresaDatos.getVision());
            empresa.setUrlLogo(empresaDatos.getUrlLogo());

            if (empresaDatos.isActiva()) {
                empresaRepository.desactivarTodas();
                empresa.setActiva(true);
            } else {
                empresa.setActiva(false);
            }

            return empresaRepository.save(empresa);
        });
    }

    @Transactional
    public boolean eliminar(Long id) {
        if (empresaRepository.existsById(id)) {
            empresaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
