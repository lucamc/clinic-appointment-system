package com.example.consultorioApp.dto.response.odontologo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OdontologoSalidaDTO {

    // Atributos
    private Long id;
    private String nombre;
    private String apellido;
    private String matricula;

    // Constrcutor
    public OdontologoSalidaDTO() {

    }

    public OdontologoSalidaDTO(Long id, String nombre, String apellido, String matricula) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }
}
