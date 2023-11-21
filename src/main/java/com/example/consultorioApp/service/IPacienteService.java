package com.example.consultorioApp.service;

import com.example.consultorioApp.dto.request.paciente.PacienteEntradaDTO;
import com.example.consultorioApp.dto.request.update.PacienteActualizadoEntradaDTO;
import com.example.consultorioApp.dto.response.paciente.PacienteSalidaDTO;
import com.example.consultorioApp.exception.BadRequestException;
import com.example.consultorioApp.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface IPacienteService {

    PacienteSalidaDTO registrarPaciente(PacienteEntradaDTO paciente) throws ResourceNotFoundException;

    PacienteSalidaDTO actualizarPaciente(PacienteActualizadoEntradaDTO paciente) throws BadRequestException;

    PacienteSalidaDTO buscarPaciente(Long id) throws BadRequestException;

    List<PacienteSalidaDTO> listarPacientes();

    void eliminarPaciente(Long id) throws ResourceNotFoundException;
}
