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

    private String calle;

    private String numero;

    private String localidad;

    // Constructor
    public Domicilio(String calle, String numero, String localidad) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
    }
}
