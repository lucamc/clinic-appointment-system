package com.example.consultorioApp.dto.response.paciente;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PacienteSalidaDTO {

    // Atributos
    private Long id;
    private String nombre;
    private String apellido;
    private int dni;
    private LocalDate fechaIngreso;
    private DomicilioSalidaDTO domicilio;

    // Constrcutor
    public PacienteSalidaDTO() {
    }

    public PacienteSalidaDTO(Long id, String nombre, String apellido, int dni, LocalDate fechaIngreso, DomicilioSalidaDTO domicilio) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
    }
}
