package com.example.consultorioApp.dto.response.turno;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OdontologoTurnoSalidaDTO {

    // Atributos
    private Long id;
    private String nombreOdontologo;
    private String apellidoOdontologo;

    // Constructor
    public OdontologoTurnoSalidaDTO() {
    }

    public OdontologoTurnoSalidaDTO(Long id, String nombreOdontologo, String apellidoOdontologo) {
        this.id = id;
        this.nombreOdontologo = nombreOdontologo;
        this.apellidoOdontologo = apellidoOdontologo;
    }
}
