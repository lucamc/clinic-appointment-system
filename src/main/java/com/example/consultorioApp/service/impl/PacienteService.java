package com.example.consultorioApp.service.impl;


import com.example.consultorioApp.exception.ResourceNotFoundException;
import com.example.consultorioApp.model.Paciente;
import com.example.consultorioApp.repository.IPacienteRepository;
import com.example.consultorioApp.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService implements IPacienteService {

    private final IPacienteRepository pacienteRepository;

    @Autowired
    public PacienteService(IPacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public PacienteDTO registrarPaciente(PacienteDTO pacienteDTO) {
        Paciente paciente = convertirEntidad(pacienteDTO);
        Paciente nuevoPaciente = pacienteRepository.save(paciente);
        return convertirADTO(nuevoPaciente);
    }

    @Override
    public PacienteDTO actualizarPaciente(PacienteDTO pacienteActualizadoDTO) {
        Paciente pacienteExistente = pacienteRepository.findById(pacienteActualizadoDTO.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Paciente no encontrado"));
        pacienteExistente.setNombre(pacienteActualizadoDTO.getNombre());
        pacienteExistente.setApellido(pacienteActualizadoDTO.getApellido());
        pacienteExistente.setDni(pacienteActualizadoDTO.getDni());
        pacienteExistente.setFechaIngreso(pacienteActualizadoDTO.getFechaIngreso());
        pacienteExistente.setDomicilio(DomicilioDTO.convertirEntidad(pacienteActualizadoDTO.getDomicilio()));
        pacienteRepository.save(pacienteExistente);
        return convertirADTO(pacienteExistente);
    }

    @Override
    public Optional<PacienteDTO> buscarPaciente(Long id) {
        Optional<Paciente> paciente = Optional.ofNullable(pacienteRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Paciente no encontrado")));
        return paciente.map(this::convertirADTO);
    }

    @Override
    public List<PacienteDTO> listarPacientes() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        return pacientes.stream()
                .map(this::convertirADTO)
                .collect(java.util.stream.Collectors.toList());
    }

    @Override
    public void eliminarPaciente(Long id) {
        pacienteRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Paciente no encontrado"));
        pacienteRepository.deleteById(id);
    }


    private PacienteDTO convertirADTO(Paciente paciente) {
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setId(paciente.getId());
        pacienteDTO.setNombre(paciente.getNombre());
        pacienteDTO.setApellido(paciente.getApellido());
        pacienteDTO.setDni(paciente.getDni());
        pacienteDTO.setFechaIngreso(paciente.getFechaIngreso());

        // Convierte el Domicilio a un DomicilioDTO (si el paciente tiene domicilio)
        if (paciente.getDomicilio() != null) {
            pacienteDTO.setDomicilio(DomicilioDTO.convertirADTO(paciente.getDomicilio()));
        }

        return pacienteDTO;
    }


    private Paciente convertirEntidad(PacienteDTO pacienteDTO) {
        Paciente paciente = new Paciente();
        paciente.setNombre(pacienteDTO.getNombre());
        paciente.setApellido(pacienteDTO.getApellido());
        paciente.setDni(pacienteDTO.getDni());
        paciente.setFechaIngreso(pacienteDTO.getFechaIngreso());

        if (pacienteDTO.getDomicilio() != null) {
            // Convierte el DomicilioDTO a Domicilio
            paciente.setDomicilio(DomicilioDTO.convertirEntidad(pacienteDTO.getDomicilio()));
        }

        return paciente;
    }


}
