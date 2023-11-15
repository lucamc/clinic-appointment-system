package com.example.consultorioApp.dto;

import com.example.consultorioApp.model.Domicilio;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class PacienteDTO implements Serializable {

    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private DomicilioDTO domicilio;
    private LocalDate fechaIngreso;


    public PacienteDTO() {
    }

    public PacienteDTO(Long id, String nombre, String apellido, String dni, DomicilioDTO domicilio, LocalDate fechaIngreso) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.domicilio = domicilio;
        this.fechaIngreso = fechaIngreso;
    }

    @Override
    public String toString() {
        return "PacienteDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                ", domicilio=" + domicilio +
                ", fechaIngreso='" + fechaIngreso + '\'' +
                '}';
    }
}
