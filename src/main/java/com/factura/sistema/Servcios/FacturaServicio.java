package com.factura.sistema.Servcios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.factura.sistema.Entidades.Cliente;
import com.factura.sistema.Entidades.DetFactura;
import com.factura.sistema.Entidades.Factura;
import com.factura.sistema.Entidades.Producto;
import com.factura.sistema.Repositorios.ClienteRespositorio;
import com.factura.sistema.Repositorios.DetFacturaRepositorio;
import com.factura.sistema.Repositorios.FacturaRepositorio;
import com.factura.sistema.Repositorios.ProductoRespositorio;

import jakarta.transaction.Transactional;

public class FacturaServicio {
    @Autowired
    private FacturaRepositorio facturaRepositorio;
    @Autowired
    private DetFacturaRepositorio detFacturaRepositorio;
    @Autowired
    private ClienteRespositorio clienteRespositorio;
    @Autowired
    private ProductoRespositorio productoRespositorio;

    @Transactional
    public Factura guardar(Factura factura){
        Cliente cliente= clienteRespositorio.findById(factura.getCliente().getId()).
        orElseThrow(()-> new RuntimeException("Cliente no encontrado"));
        Factura facturaNew=new Factura();
        facturaNew.setCliente(cliente);
        facturaNew.setFecha(factura.getFecha());
        List<DetFactura> detalles=new ArrayList<>();
        for(DetFactura detF: factura.getDetFactura()){
            Producto producto= productoRespositorio.findById(detF.getProducto().getId()).
            orElseThrow(()-> new RuntimeException("producto no encontrado"));
            DetFactura detFactura=new DetFactura();
            detFactura.setFactura(facturaNew);
            detFactura.setProducto(producto);
            detFactura.setCantidad(detF.getCantidad());
            detFactura.setPrecio(detF.getPrecio());
            detFactura.setTotal(detF.getTotal());
            detalles.add(detFactura);
        }
        facturaNew.setIva15(factura.getIva15());
        facturaNew.setSubtotal0(factura.getSubtotal0());
        facturaNew.setSubtotal15(factura.getSubtotal15());
        facturaNew.setTotal(factura.getTotal());
        facturaRepositorio.save(facturaNew);
        for(DetFactura det: detalles){
            det.setFactura(facturaNew);
            detFacturaRepositorio.save(det);
        }
        return factura;
    }
    public List<Factura> listaAll(){
        return facturaRepositorio.findAll();
    }
    public Factura listaFactura(Long id){
        return facturaRepositorio.findById(id).orElse(null);
    }
    public void eliminar(Long id){
        facturaRepositorio.deleteById(id);
    }

}
