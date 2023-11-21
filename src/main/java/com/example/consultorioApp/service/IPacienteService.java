package com.example.consultorioApp.service;

import com.example.consultorioApp.dto.request.paciente.PacienteEntradaDTO;
import com.example.consultorioApp.dto.request.update.PacienteActualizadoEntradaDTO;
import com.example.consultorioApp.dto.response.paciente.PacienteSalidaDTO;

import java.util.List;
import java.util.Optional;

public interface IPacienteService {

    PacienteSalidaDTO registrarPaciente(PacienteEntradaDTO paciente);

    PacienteSalidaDTO actualizarPaciente(PacienteActualizadoEntradaDTO paciente);

    PacienteSalidaDTO buscarPaciente(Long id);

    List<PacienteSalidaDTO> listarPacientes();

    void eliminarPaciente(Long id);
}
