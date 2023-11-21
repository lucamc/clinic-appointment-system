package com.example.consultorioApp.dto.request.update;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class DomicilioActualizadoEntradaDTO {

    @NotNull
    private Long id;

    @NotNull
    private String calle;

    @NotNull
    private String numero;

    @NotNull
    private String localidad;

    public DomicilioActualizadoEntradaDTO() {
    }

    public DomicilioActualizadoEntradaDTO(Long id, String calle, String numero, String localidad) {
        this.id = id;
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
    }
}
