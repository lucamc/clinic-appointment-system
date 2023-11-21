package com.example.consultorioApp.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "PACIENTES")
public class Paciente {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String apellido;

    private String dni;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "domicilio_id", referencedColumnName = "id")
    private Domicilio domicilio;

    @Column(name ="fecha_ingreso")
    private LocalDate fechaIngreso;


    // Constructor
    public Paciente(String nombre, String apellido, Domicilio domicilio, String dni, LocalDate fechaIngreso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
    }
}
