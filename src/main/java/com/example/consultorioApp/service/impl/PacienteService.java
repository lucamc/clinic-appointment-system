package com.example.consultorioApp.service.impl;


import com.example.consultorioApp.dto.request.paciente.PacienteEntradaDTO;
import com.example.consultorioApp.dto.request.update.PacienteActualizadoEntradaDTO;
import com.example.consultorioApp.dto.response.paciente.PacienteSalidaDTO;
import com.example.consultorioApp.exception.BadRequestException;
import com.example.consultorioApp.exception.ResourceNotFoundException;
import com.example.consultorioApp.model.Paciente;
import com.example.consultorioApp.repository.IPacienteRepository;
import com.example.consultorioApp.service.IPacienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService implements IPacienteService {

    private final IPacienteRepository pacienteRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public PacienteService(IPacienteRepository pacienteRepository, ModelMapper modelMapper) {
        this.pacienteRepository = pacienteRepository;
        this.modelMapper = modelMapper;
        configureMapping();
    }

    @Override
    public PacienteSalidaDTO registrarPaciente(PacienteEntradaDTO paciente) {
        // Convierte el DTO de entrada a una entidad
        Paciente pacienteIngresado = dtoEntradaAEntidad(paciente);

        // Guarda la entidad en la base de datos
        Paciente pacienteRegistrado = pacienteRepository.save(pacienteIngresado);
        return entidadAdtoSalida(pacienteRegistrado);
    }

    @Override
    public PacienteSalidaDTO actualizarPaciente(PacienteActualizadoEntradaDTO paciente) throws BadRequestException {
        // Busca el paciente y lanza una excepción si no se encuentra
        Paciente pacienteActualizar = pacienteRepository.findById(paciente.getId())
                .orElseThrow(() -> new BadRequestException("No se encontro el paciente con id: " + paciente.getId()));
        // Actualiza y guarda el paciente
        Paciente pacienteActualizado = dtoActualizadoAEntidad(paciente);
        pacienteRepository.save(pacienteActualizado);

        // Convierte el paciente actualizado a DTO y lo retorna
        return entidadAdtoSalida(pacienteActualizado);
    }

    public PacienteSalidaDTO buscarPaciente(Long id) throws BadRequestException{
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("No se encontro el paciente con id: " + id));
        return entidadAdtoSalida(paciente);
    }

    @Override
    public List<PacienteSalidaDTO> listarPacientes() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        return pacientes.stream().map(this::entidadAdtoSalida).toList();
    }

    @Override
    public void eliminarPaciente(Long id) throws ResourceNotFoundException {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        if (paciente.isEmpty()) {
            throw new ResourceNotFoundException("No se encontro el paciente con id: " + id);
        }
        pacienteRepository.deleteById(id);
    }

    public void configureMapping() {
        // Mapeo de PacienteEntradaDTO a Paciente
        modelMapper.createTypeMap(PacienteEntradaDTO.class, Paciente.class)
                .addMappings(mapper -> mapper.map(PacienteEntradaDTO::getDomicilio, Paciente::setDomicilio));

        // Mapeo de Paciente a PacienteSalidaDTO
        modelMapper.createTypeMap(Paciente.class, PacienteSalidaDTO.class)
                .addMappings(mapper -> mapper.map(Paciente::getDomicilio, PacienteSalidaDTO::setDomicilio));

        // Mapeo de PacienteActualizadoEntradaDTO a Paciente
        modelMapper.createTypeMap(PacienteActualizadoEntradaDTO.class, Paciente.class)
                .addMappings(mapper -> mapper.map(PacienteActualizadoEntradaDTO::getDomicilio, Paciente::setDomicilio));
    }


    public Paciente dtoEntradaAEntidad(PacienteEntradaDTO paciente) {
        return modelMapper.map(paciente, Paciente.class);
    }

    public PacienteSalidaDTO entidadAdtoSalida(Paciente paciente) {
        return modelMapper.map(paciente, PacienteSalidaDTO.class);
    }

    public Paciente dtoActualizadoAEntidad(PacienteActualizadoEntradaDTO paciente) {
        return modelMapper.map(paciente, Paciente.class);
    }

}
