package com.factura.sistema.Entidades;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Factura {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fecha;
    @PositiveOrZero(message =  "El valor tiene que ser mayor cero")
    private Double total;
    private Double subtotal0;
    private Double subtotal15;
    private Double iva15;
    @ManyToOne
    @JoinColumn(name="cliente_id")
    private Cliente cliente;

    @OneToMany (mappedBy = "factura", cascade = CascadeType.ALL)
    private List<DetFactura> detFactura= new ArrayList<>();

}

