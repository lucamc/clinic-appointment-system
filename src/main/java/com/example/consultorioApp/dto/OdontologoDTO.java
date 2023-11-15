package com.example.consultorioApp.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class OdontologoDTO implements Serializable {

    // Atributos
    private Long id;
    private String nombre;
    private String apellido;
    private String matricula;

    // Constructores
    public OdontologoDTO() {
    }

    public OdontologoDTO(Long id, String nombre, String apellido, String matricula) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }

    // Método toString para mostrar los datos de la clase
    @Override
    public String toString() {
        return "OdontologoDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", matricula='" + matricula + '\'' +
                '}';
    }
}
