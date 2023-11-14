package com.example.consultorioApp.controller;

import com.example.consultorioApp.model.Paciente;
import com.example.consultorioApp.service.impl.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    // Constructor de la clase PacienteController
    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    // Metodo POST que registra un paciente
    @PostMapping("registrar")
    public ResponseEntity<Paciente> registrarPaciente(@Valid @RequestBody Paciente paciente) {
        Paciente pacienteRegistrado = pacienteService.registrarPaciente(paciente);
        return ResponseEntity.ok(pacienteRegistrado);
    }

    // Metodo PUT que modifica un paciente
    @PutMapping("actualizar")
    public ResponseEntity<Paciente> actualizarPaciente(@Valid @RequestBody Paciente paciente) {

        // Si el paciente no existe, devuelve un status 404
        if (pacienteService.buscarPaciente(paciente.getId()).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            // Si el paciente existe, devuelve el paciente actualizado
            Paciente pacienteActualizado = pacienteService.actualizarPaciente(paciente);
            return ResponseEntity.ok(pacienteActualizado);
        }
    }

    // Metodo GET que busca un paciente por id
    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPaciente(@PathVariable Long id) {
        Paciente paciente = pacienteService.buscarPaciente(id).orElse(null);
        return ResponseEntity.ok(paciente);
    }

    // Metodo GET que lista todos los pacientes
    @GetMapping
    public ResponseEntity<List<Paciente>> listarPacientes() {
        List<Paciente> pacientes = pacienteService.listarPacientes();
        return ResponseEntity.ok(pacientes);
    }


    // Metodo DELETE que elimina un paciente por id
    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<String> eliminarPaciente(@PathVariable Long id) {
        Optional<Paciente> paciente = pacienteService.buscarPaciente(id);

        // Si el paciente no existe, devuelve un status 404
        if (paciente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente no encontrado");
        } else {
            // Si el paciente existe, lo elimina y devuelve un status 204
            pacienteService.eliminarPaciente(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }
}
