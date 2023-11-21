package com.example.consultorioApp.dto.request.update;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PacienteActualizadoEntradaDTO {

    @NotNull
    private Long id;

    @NotNull
    private String nombre;

    @NotNull
    private String apellido;

    @NotNull
    @Pattern(regexp = "^[0-9]{8}$")
    private String dni;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate fechaIngreso;

    @NotNull
    private DomicilioActualizadoEntradaDTO domicilio;

    public PacienteActualizadoEntradaDTO() {

    }

    public PacienteActualizadoEntradaDTO(Long id, String nombre, String apellido, String dni, LocalDate fechaIngreso, DomicilioActualizadoEntradaDTO domicilio) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
    }


}
