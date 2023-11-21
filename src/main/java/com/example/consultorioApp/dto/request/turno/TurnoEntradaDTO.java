package com.example.consultorioApp.dto.request.turno;

import com.example.consultorioApp.model.Turno;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TurnoEntradaDTO {

    // Atributos
    @NotNull(message = "El id del odontologo no puede ser nulo")
    private Long odontologoId;

    @NotNull(message = "El id del paciente no puede ser nulo")
    private Long pacienteId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    @FutureOrPresent(message = "La fecha y hora debe ser presente o futura")
    @NotNull(message = "La fecha y hora no puede ser nula")
    private LocalDateTime fechaHora;

    public TurnoEntradaDTO() {

    }

    public TurnoEntradaDTO(Long odontologoId, Long pacienteId, LocalDateTime fechaHora) {
        this.odontologoId = odontologoId;
        this.pacienteId = pacienteId;
        this.fechaHora = fechaHora;
    }
}
