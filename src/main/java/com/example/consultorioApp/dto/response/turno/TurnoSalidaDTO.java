package com.example.consultorioApp.dto.response.turno;

import lombok.Getter;
import lombok.Setter;



public class TurnoSalidaDTO {

    // Atributos
    private Long id;
    private OdontologoTurnoSalidaDTO odontologoTurnoSalidaDTO;
    private PacienteTurnoSalidaDTO pacienteTurnoSalidaDTO;

    // Constructor
    public TurnoSalidaDTO() {
    }

    public TurnoSalidaDTO(Long id, OdontologoTurnoSalidaDTO odontologoTurnoSalidaDTO, PacienteTurnoSalidaDTO pacienteTurnoSalidaDTO) {
        this.id = id;
        this.odontologoTurnoSalidaDTO = odontologoTurnoSalidaDTO;
        this.pacienteTurnoSalidaDTO = pacienteTurnoSalidaDTO;
    }

    public Long getId() {
        return id;
    }

    public OdontologoTurnoSalidaDTO getOdontologoTurnoSalidaDTO() {
        return odontologoTurnoSalidaDTO;
    }

    public PacienteTurnoSalidaDTO getPacienteTurnoSalidaDTO() {
        return pacienteTurnoSalidaDTO;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOdontologoTurnoSalidaDTO(OdontologoTurnoSalidaDTO odontologoTurnoSalidaDTO) {
        this.odontologoTurnoSalidaDTO = odontologoTurnoSalidaDTO;
    }

    public void setPacienteTurnoSalidaDTO(PacienteTurnoSalidaDTO pacienteTurnoSalidaDTO) {
        this.pacienteTurnoSalidaDTO = pacienteTurnoSalidaDTO;
    }
}