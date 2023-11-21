package com.example.consultorioApp.dto.response.turno;

import lombok.Getter;
import lombok.Setter;



public class PacienteTurnoSalidaDTO {

    // Atributos
    private Long id;
    private String nombrePaciente;
    private String apellidoPaciente;

    // Constructor
    public PacienteTurnoSalidaDTO() {
    }

    public PacienteTurnoSalidaDTO(Long id, String nombrePaciente, String apellidoPaciente) {
        this.id = id;
        this.nombrePaciente = nombrePaciente;
        this.apellidoPaciente = apellidoPaciente;
    }

    public Long getId() {
        return id;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public String getApellidoPaciente() {
        return apellidoPaciente;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public void setApellidoPaciente(String apellidoPaciente) {
        this.apellidoPaciente = apellidoPaciente;
    }
}
