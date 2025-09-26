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

import com.factura.sistema.Entidades.Cliente;
import com.factura.sistema.Servcios.ClienteServicio;

@RestController
@RequestMapping("/api/cliente")
public class ClienteControlador {

    @Autowired 
    private ClienteServicio clienteServicio;

    @PostMapping
    public Cliente crear(@RequestBody Cliente cliente){
        return clienteServicio.guardar(cliente);
    }
    @PutMapping("/{id}")
    public Cliente actualizar(@RequestBody Cliente cliente, @PathVariable Long id){
        cliente.setId(id);
        return clienteServicio.guardar(cliente);
    }
    @GetMapping
    public List<Cliente> listar(){
        return clienteServicio.listaAll();
    }
    @GetMapping("/{id}")
    public Cliente obtener(@PathVariable Long id){
        return clienteServicio.listaCliente(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        clienteServicio.eliminar(id);
    }
}
