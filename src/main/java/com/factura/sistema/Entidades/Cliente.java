package com.factura.sistema.Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Cliente {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;
   
    @Column(name="clienteCedula" , length = 200 ,nullable = false)
    private String cedula;
    @NotBlank(message = "El nombre no esvalido")
    @Size(min = 3, max = 200 , message = "El nombre no esta 3 a 200 caracteres")
    private String nombre;
    @NotBlank(message = "El apellido no esvalido")
    @Size(min = 3, max = 200 , message = "El apellido no esta 3 a 200 caracteres")
    private String apellido;
    private String telefono;
    private String direccion;
    @Email(message = "Correo incorrecto") 
    private String correo;
}
