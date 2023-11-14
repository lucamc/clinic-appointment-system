package com.example.consultorioApp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Domicilio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "La calle no puede estar vacia")
    private String calle;

    @NotEmpty(message = "El numero no puede estar vacio")
    private String numero;

    @NotEmpty(message = "La localidad no puede estar vacia")
    private String localidad;

    // Constructor
    public Domicilio(String calle, String numero, String localidad) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
    }
}
