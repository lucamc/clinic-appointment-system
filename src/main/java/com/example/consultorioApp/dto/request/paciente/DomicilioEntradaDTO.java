package com.example.consultorioApp.dto.request.paciente;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class DomicilioEntradaDTO {

    // Atributos
    @NotNull(message = "La calle no puede ser nulo")
    @NotBlank(message = "Especificar el nombre de la calle")
    private String calle;


    @NotNull(message = "El numero no puede ser nulo")
    @NotBlank(message = "Especificar el numero")
    private String numero;


    @NotNull(message = "La localidad no puede ser nulo")
    @NotBlank(message = "Especificar el nombre de la localidad")
    private String localidad;

    // Constructor
    public DomicilioEntradaDTO() {

    }

    public DomicilioEntradaDTO(String calle, String numero, String localidad) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
    }
}
