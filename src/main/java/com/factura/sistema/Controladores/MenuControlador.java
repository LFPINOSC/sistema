package com.factura.sistema.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.factura.sistema.Entidades.Menu;
import com.factura.sistema.Servcios.MenuServicio;

@RestController
@RequestMapping("/api/menu")
public class MenuControlador {
     @Autowired 
    private MenuServicio menuServicio;

    @PostMapping
    public Menu crear(@RequestBody Menu menu){
        return menuServicio.guardar(menu);
    }
    @PutMapping("/{id}")
    public Menu actualizar(@RequestBody Menu menu, @PathVariable Long id){
        menu.setId(id);
        return menuServicio.guardar(menu);
    }
    @GetMapping
    public List<Menu> listar(){
        return menuServicio.listaAll();
    }
    @GetMapping("/{id}")
    public Menu obtener(@PathVariable Long id){
        return menuServicio.listaMenu(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        menuServicio.eliminar(id);
    }
}
