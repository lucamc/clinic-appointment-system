package com.example.consultorioApp.controller;

import com.example.consultorioApp.dto.request.paciente.PacienteEntradaDTO;
import com.example.consultorioApp.dto.request.update.PacienteActualizadoEntradaDTO;
import com.example.consultorioApp.dto.response.paciente.PacienteSalidaDTO;
import com.example.consultorioApp.exception.BadRequestException;
import com.example.consultorioApp.exception.ResourceNotFoundException;
import com.example.consultorioApp.service.impl.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    // Constructor de la clase PacienteController
    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    // Metodo POST que Registra un paciente
    @PostMapping("registrar")
    public ResponseEntity<PacienteSalidaDTO> registrarPaciente(@Valid @RequestBody PacienteEntradaDTO paciente) {
        return new ResponseEntity<>(pacienteService.registrarPaciente(paciente), HttpStatus.CREATED);
    }

    // Metodo PUT que Actualiza un paciente
    @PutMapping("actualizar")
    public ResponseEntity<PacienteSalidaDTO> actualizarPaciente(@Valid @RequestBody PacienteActualizadoEntradaDTO paciente) throws BadRequestException {
        return new ResponseEntity<>(pacienteService.actualizarPaciente(paciente), HttpStatus.OK);
    }

    // Metodo GET que Busca un paciente por id
    @GetMapping("/{id}")
    public ResponseEntity<PacienteSalidaDTO> buscarPaciente(@PathVariable Long id) throws BadRequestException {
        return new ResponseEntity<>(pacienteService.buscarPaciente(id), HttpStatus.OK);
    }

    // Metodo GET que lista todos los pacientes
    @GetMapping
    public ResponseEntity<List<PacienteSalidaDTO>> listarPacientes() {
        return new ResponseEntity<>(pacienteService.listarPacientes(), HttpStatus.OK);
    }


    // Metodo DELETE que elimina un paciente por id
    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<Void> eliminarPaciente(@PathVariable Long id) throws ResourceNotFoundException {
        pacienteService.eliminarPaciente(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
