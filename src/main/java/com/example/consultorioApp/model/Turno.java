package com.example.consultorioApp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@Entity
@NoArgsConstructor
@Getter
@Setter
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "turno_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "odontologo_id", nullable = false)
    @NotNull(message = "Debe asignarse un odontólogo al turno")
    private Odontologo odontologo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "paciente_id", nullable = false)
    @NotNull(message = "Debe asignarse un paciente al turno")
    private Paciente paciente;

    @Column(name = "fecha_hora", nullable = false)
    @NotNull(message = "La fecha y hora del turno no puede ser nulas")
    private LocalDateTime fechaHora;

    public Turno(Odontologo odontologo, Paciente paciente, LocalDateTime fechaHora) {
        this.odontologo = odontologo;
        this.paciente = paciente;
        this.fechaHora = fechaHora;
    }


}
