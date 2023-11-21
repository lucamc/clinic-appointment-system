package com.example.consultorioApp.dto.request.update;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TurnoActualizadoEntradaDTO {

    @NotNull
    private Long id;

    @NotNull
    private Long odontologoId;

    @NotNull
    private Long pacienteId;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime fechaHora;

    // Constructor
    public TurnoActualizadoEntradaDTO() {
    }

    public TurnoActualizadoEntradaDTO(Long id, Long odontologoId, Long pacienteId, LocalDateTime fechaHora) {
        this.id = id;
        this.odontologoId = odontologoId;
        this.pacienteId = pacienteId;
        this.fechaHora = fechaHora;
    }

}
