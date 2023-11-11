package com.example.consultorioApp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Paciente {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paciente_id")
    private Long id;

    @NotEmpty(message = "El nombre no puede estar vacio")
    private String nombre;

    @NotEmpty(message = "El apellido no puede estar vacio")
    private String apellido;

    @NotEmpty(message = "El domicilio no puede estar vacio")
    private String domicilio;

    @NotNull(message = "El DNI no puede ser nulo")
    private String dni;

    @Column(name ="fecha_de_alta")
    @NotNull(message = "La fecha de alta no puede ser nula")
    private LocalDate fechaDeAlta;

    @OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY)
    private Set<Turno> turnos = new HashSet<>();

    // Constructor
    public Paciente(String nombre, String apellido, String domicilio,String dni, LocalDate fechaDeAlta) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.dni = dni;
        this.fechaDeAlta = fechaDeAlta;
    }
}
