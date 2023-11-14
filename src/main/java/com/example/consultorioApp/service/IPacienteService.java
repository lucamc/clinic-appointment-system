package com.example.consultorioApp.service;

import com.example.consultorioApp.model.Paciente;
import java.util.List;
import java.util.Optional;

public interface IPacienteService {

    Paciente registrarPaciente(Paciente paciente);

    Paciente actualizarPaciente(Paciente pacienteModificado);

    Optional<Paciente> buscarPaciente(Long id);

    List<Paciente> listarPacientes();

    void eliminarPaciente(Long id);
}
