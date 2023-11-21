package com.example.consultorioApp.dto.request.odontologo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OdontologoEntradaDTO {

    // Atributos
    @Size(max = 50, message = "El nombre no puede tener mas de 50 caracteres")
    @NotNull(message = "El nombre no puede ser nulo")
    @NotBlank(message = "Especificar el nombre")
    private String nombre;

    @Size(max = 50, message = "El apellido no puede tener mas de 50 caracteres")
    @NotNull(message = "El apellido no puede ser nulo")
    @NotBlank(message = "Especificar el apellido")
    private String apellido;

    @NotNull(message = "La matricula no puede ser nulo")
    @NotBlank(message = "Especificar la matricula")
    private String matricula;

    // Constructor
    public OdontologoEntradaDTO() {
    }

    public OdontologoEntradaDTO(String nombre, String apellido, String matricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }


}
