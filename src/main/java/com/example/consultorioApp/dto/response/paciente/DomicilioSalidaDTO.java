package com.example.consultorioApp.dto.response.paciente;


import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;


@Getter
@Setter
public class DomicilioSalidaDTO {

    // Atributos
    private Long id;
    private String calle;
    private String numero;
    private String localidad;

    // Constructor
    public DomicilioSalidaDTO() {
    }

    public DomicilioSalidaDTO(Long id, String calle, String numero, String localidad) {
        this.id = id;
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
    }

}
