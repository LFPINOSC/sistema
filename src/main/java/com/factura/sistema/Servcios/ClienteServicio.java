package com.factura.sistema.Servcios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.factura.sistema.Entidades.Cliente;
import com.factura.sistema.Repositorios.ClienteRespositorio;

public class ClienteServicio {
    @Autowired
    private ClienteRespositorio clienteRespositorio;

    public Cliente guardar(Cliente cliente){
        return clienteRespositorio.save(cliente);
    }
    public List<Cliente> listaAll(){
        return clienteRespositorio.findAll();
    }
    public Cliente listaCliente(Long id){
        return clienteRespositorio.findById(id).orElse(null);
    }
    public void eliminar(Long id){
        clienteRespositorio.deleteById(id);
    }
}
