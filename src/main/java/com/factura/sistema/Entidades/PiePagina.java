package com.factura.sistema.Entidades;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PiePagina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500)
    private String texto;

    @Column(length = 255)
    private String correoContacto;

    @Column(length = 255)
    private String telefono;

    @Column(length = 255)
    private String direccion;
}
