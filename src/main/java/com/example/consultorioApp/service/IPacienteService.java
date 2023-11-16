package com.example.consultorioApp.service;

import java.util.List;
import java.util.Optional;

public interface IPacienteService {

    PacienteDTO registrarPaciente(PacienteDTO pacienteDTO);

    PacienteDTO actualizarPaciente(PacienteDTO pacienteActualizadoDTO);

    Optional<PacienteDTO> buscarPaciente(Long id);

    List<PacienteDTO> listarPacientes();

    void eliminarPaciente(Long id);
}
