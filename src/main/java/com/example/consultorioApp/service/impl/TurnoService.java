package com.example.consultorioApp.service.impl;

import com.example.consultorioApp.dto.request.turno.TurnoEntradaDTO;
import com.example.consultorioApp.dto.request.update.TurnoActualizadoEntradaDTO;
import com.example.consultorioApp.dto.response.odontologo.OdontologoSalidaDTO;
import com.example.consultorioApp.dto.response.paciente.PacienteSalidaDTO;
import com.example.consultorioApp.dto.response.turno.TurnoSalidaDTO;
import com.example.consultorioApp.model.Odontologo;
import com.example.consultorioApp.model.Paciente;
import com.example.consultorioApp.model.Turno;
import com.example.consultorioApp.repository.ITurnoRepository;
import com.example.consultorioApp.service.ITurnoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoService implements ITurnoService {

    private final ITurnoRepository turnoRepository;
    private final ModelMapper modelMapper;
    private final PacienteService pacienteService;
    private final OdontologoService odontologoService;

    @Autowired
    public TurnoService(ITurnoRepository turnoRepository, ModelMapper modelMapper, PacienteService pacienteService, OdontologoService odontologoService) {


        this.turnoRepository = turnoRepository;
        this.modelMapper = modelMapper;
        this.pacienteService = pacienteService;
        this.odontologoService = odontologoService;
        configureMappings();

    }

    @Override
    public TurnoSalidaDTO registrarTurno(TurnoEntradaDTO turnoEntradaDTO) {
        TurnoSalidaDTO turnoSalidaDTO = null;

        PacienteSalidaDTO paciente = pacienteService.buscarPaciente(turnoEntradaDTO.getPacienteId());
        OdontologoSalidaDTO odontologo = odontologoService.buscarOdontologo(turnoEntradaDTO.getOdontologoId());

        String pacienteNoEnBdd = "No se encontró el paciente con id: " + turnoEntradaDTO.getPacienteId() + " en la base de datos";
        String odontologoNoEnBdd = "No se encontró el odontólogo con id: " + turnoEntradaDTO.getOdontologoId() + " en la base de datos";

        if (paciente == null || odontologo == null) {
            if (paciente == null && odontologo == null) {
                throw new RuntimeException("El paciente y el odontólogo no se encontraron en la base de datos");
            } else if (paciente == null) {
                throw new RuntimeException(pacienteNoEnBdd);
            } else {
                throw new RuntimeException(odontologoNoEnBdd);
            }
        } else {
            // Convierte el DTO de entrada a una entidad y lo guarda en la base de datos
            Turno turnoIngresado = turnoRepository.save(dtoEntradaAEntidad(turnoEntradaDTO));
            turnoSalidaDTO = entidadADto(turnoIngresado);
        }

        return turnoSalidaDTO;

    }

    @Override
    public TurnoSalidaDTO actualizarTurno (TurnoActualizadoEntradaDTO turnoEntradaActualizadoDto) {
        // Busca el turno existente
        Turno turnoExistente = turnoRepository.findById(turnoEntradaActualizadoDto.getId())
                .orElseThrow(() -> new RuntimeException("No se encontró el turno con id: " + turnoEntradaActualizadoDto.getId()));

        // Actualiza los campos del turno existente
        turnoExistente.setFechaHora(turnoEntradaActualizadoDto.getFechaHora());
        turnoExistente.setOdontologo(modelMapper.map(odontologoService.buscarOdontologo(turnoEntradaActualizadoDto.getOdontologoId()), Odontologo.class));
        turnoExistente.setPaciente(modelMapper.map(pacienteService.buscarPaciente(turnoEntradaActualizadoDto.getPacienteId()), Paciente.class));

        // Guarda el turno actualizado
        Turno turnoActualizado = turnoRepository.save(turnoExistente);

        // Convierte el turno actualizado a DTO y lo retorna
        return entidadADto(turnoActualizado);
    }


    @Override
    public TurnoSalidaDTO buscarTurnoPorId(Long id) {
        Turno turno = turnoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el turno con id: " + id));
        return entidadADto(turno);
    }

    @Override
    public List<TurnoSalidaDTO> listarTurnos() {
        List<Turno> turnos = turnoRepository.findAll();
        return turnos.stream().map(this::entidadADto).toList();
    }

    @Override
    public void eliminarTurno(Long id) {
        Optional<Turno> turno = turnoRepository.findById(id);
        if (turno.isEmpty()) {
            throw new RuntimeException("No se encontró el turno con id: " + id);
        }
        turnoRepository.deleteById(id);

    }


    private void configureMappings() {
        modelMapper.typeMap(Turno.class , TurnoSalidaDTO.class)
                .addMappings(mapper -> mapper.map(Turno::getPaciente, TurnoSalidaDTO::setPacienteTurnoSalidaDTO))
                .addMappings(mapper -> mapper.map(Turno::getOdontologo, TurnoSalidaDTO::setOdontologoTurnoSalidaDTO)
                );

        modelMapper.typeMap(TurnoActualizadoEntradaDTO.class, Turno.class)
                .addMappings(mapper -> mapper.map(TurnoActualizadoEntradaDTO::getOdontologoId, Turno::setOdontologo))
                .addMappings(mapper -> mapper.map(TurnoActualizadoEntradaDTO::getPacienteId, Turno::setPaciente));
    }

    public Turno dtoEntradaAEntidad(TurnoEntradaDTO turnoEntradaDTO) {
        Turno turno = new Turno();
        turno.setFechaHora(turnoEntradaDTO.getFechaHora());

        if (turnoEntradaDTO.getOdontologoId() != null) {
            OdontologoSalidaDTO odontologoDTO = odontologoService.buscarOdontologo(turnoEntradaDTO.getOdontologoId());
            Odontologo odontologo = modelMapper.map(odontologoDTO, Odontologo.class);
            turno.setOdontologo(odontologo);
        }

        if (turnoEntradaDTO.getPacienteId() != null) {
            PacienteSalidaDTO pacienteDTO = pacienteService.buscarPaciente(turnoEntradaDTO.getPacienteId());
            Paciente paciente = modelMapper.map(pacienteDTO, Paciente.class);
            turno.setPaciente(paciente);
        }

        return turno;
    }


    public TurnoSalidaDTO entidadADto(Turno turno) {
        return modelMapper.map(turno, TurnoSalidaDTO.class);
    }




}