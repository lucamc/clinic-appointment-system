package com.example.consultorioApp.service;

import com.example.consultorioApp.model.Turno;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ITurnoService {

    Turno registrarTurno(Turno turno);

    Turno actualizarTurno(Turno turnoActualizado);

    Optional<Turno> buscarTurno(Long id);

    List<Turno> listarTurnos();

    void eliminarTurno(Long id);
}
