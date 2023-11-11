package com.example.consultorioApp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Odontologo {

    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "odontologo_id")
    private Long id;

    @NotEmpty(message = "El nombre no puede estar vacio")
    private String nombre;

    @NotEmpty(message = "El apellido no puede estar vacio")
    private String apellido;

    @NotEmpty(message = "La matricula no puede estar vacio")
    private String matricula;

    @OneToMany(mappedBy = "odontologo", fetch = FetchType.LAZY)
    private Set<Turno> turnos = new HashSet<>();

    // Constructor
    public Odontologo(String nombre, String apellido, String matricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula= matricula;
    }
}
