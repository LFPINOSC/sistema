package com.factura.sistema.Entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 255)
    private String urlLogo;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
    private String nombre;

    @NotBlank(message = "La visión es obligatoria")
    @Size(max = 500, message = "La visión no puede superar los 500 caracteres")
    private String vision;

    @NotBlank(message = "La misión es obligatoria")
    @Size(max = 500, message = "La misión no puede superar los 500 caracteres")
    private String mision;

    @Column(nullable = false)
    private boolean activa = false; // Solo una empresa puede tener este valor en true
}
