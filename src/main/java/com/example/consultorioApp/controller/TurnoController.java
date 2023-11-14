package com.example.consultorioApp.controller;


import com.example.consultorioApp.model.Turno;
import com.example.consultorioApp.service.impl.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    private final TurnoService turnoService;

    @Autowired
    public TurnoController(TurnoService turnoService) {
        this.turnoService = turnoService;
    }

    // Metodo POST que registra un turno
    @PostMapping("registrar")
    public ResponseEntity<Turno> registrarTurno(@RequestBody Turno turno) {
        Turno turnoRegistrado = turnoService.registrarTurno(turno);
        return ResponseEntity.ok(turnoRegistrado);
    }

    // Metodo PUT que modifica un turno
    @PutMapping("actualizar")
    public ResponseEntity<Turno> actualizarTurno(@RequestBody Turno turno) {

        // Si el turno no existe, devuelve un status 404
        if (turnoService.buscarTurno(turno.getId()).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null)   ;
        } else {
            // Si el turno existe, devuelve el turno actualizado
            Turno turnoActualizado = turnoService.actualizarTurno(turno);
            return ResponseEntity.ok(turnoActualizado);
        }
    }

    // Metodo GET que busca un turno por id
    @GetMapping("/{id}")
    public ResponseEntity<Turno> buscarTurno(@PathVariable Long id) {
        Turno turno = turnoService.buscarTurno(id).orElse(null);
        return ResponseEntity.ok(turno);
    }

    // Metodo Get que lista todos los turnos
    @GetMapping
    public ResponseEntity<List<Turno>> listarTurnos() {
        List<Turno> turnos = turnoService.listarTurnos();
        return ResponseEntity.ok(turnos);
    }

    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<String> eliminarTurno(@PathVariable Long id) {
        Optional<Turno> turno = turnoService.buscarTurno(id);

        // Si el turno no existe, devuelve un status 404
        if (turno.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Turno no encontrado");
        } else {
            // Si el turno existe, lo elimina y devuelve un status 204
            turnoService.eliminarTurno(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }
}
