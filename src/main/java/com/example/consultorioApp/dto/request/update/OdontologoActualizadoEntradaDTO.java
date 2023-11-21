package com.example.consultorioApp.dto.request.update;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OdontologoActualizadoEntradaDTO {

    @NotNull
    private Long id;

    @NotNull
    private String nombre;

    @NotNull
    private String apellido;

    @NotNull
    private String matricula;

    public OdontologoActualizadoEntradaDTO() {
    }

    public OdontologoActualizadoEntradaDTO(Long id, String nombre, String apellido, String matricula) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }
}
