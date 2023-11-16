package com.example.consultorioApp.dto.request.paciente;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PacienteEntradaDTO {

    // Atributos

    @NotNull(message = "El nombre no puede ser nulo")
    @NotBlank(message = "Especificar el nombre")
    private String nombre;

    @NotNull(message = "El apellido no puede ser nulo")
    @NotBlank(message = "Especificar el apellido")
    private String apellido;

    @NotNull(message = "El dni no puede ser nulo")
    @Pattern(regexp = "[0-9]{8}", message = "El dni debe tener 8 digitos")
    private String dni;

    @NotNull(message = "La fecha de ingreso no puede ser nulo")
    @FutureOrPresent(message = "La fecha de ingreso debe ser presente o futura")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate fechaIngreso;

    @NotNull(message = "El domicilio no puede ser nulo")
    @NotBlank(message = "Especificar el domicilio")
    private DomicilioEntradaDTO domicilio;

    // Constructor
    public PacienteEntradaDTO() {

    }

    public PacienteEntradaDTO(String nombre, String apellido, String dni, LocalDate fechaIngreso, DomicilioEntradaDTO domicilio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
    }

}
