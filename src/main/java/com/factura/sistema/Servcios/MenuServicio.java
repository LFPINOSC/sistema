package com.factura.sistema.Servcios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.factura.sistema.Entidades.Menu;
import com.factura.sistema.Repositorios.MenuRepositorio;

import jakarta.transaction.Transactional;

@Service
public class MenuServicio {
    @Autowired
    private MenuRepositorio menuRepositorio;
    @Transactional
    public Menu guardar(Menu menu){
        return menuRepositorio.save(menu);
    }
    
    public List<Menu> listaAll(){
        return menuRepositorio.findAll();
    }
    public Menu listaMenu(Long id){
        return menuRepositorio.findById(id).orElse(null);
    }
    public void eliminar(Long id){
        menuRepositorio.deleteById(id);
    }
}
