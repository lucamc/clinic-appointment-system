package com.example.consultorioApp.controller;


import com.example.consultorioApp.dto.request.turno.TurnoEntradaDTO;
import com.example.consultorioApp.dto.request.update.TurnoActualizadoEntradaDTO;
import com.example.consultorioApp.dto.response.turno.TurnoSalidaDTO;
import com.example.consultorioApp.model.Turno;
import com.example.consultorioApp.service.impl.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<TurnoSalidaDTO> registrarTurno(@Valid @RequestBody TurnoEntradaDTO turno) {
        return new ResponseEntity<>(turnoService.registrarTurno(turno), HttpStatus.CREATED);
    }


    // Metodo PUT que modifica un turno
    @PutMapping("actualizar")
    public ResponseEntity<TurnoSalidaDTO> actualizarTurno(@Valid @RequestBody TurnoActualizadoEntradaDTO turno) {
        return new ResponseEntity<>(turnoService.actualizarTurno(turno), HttpStatus.OK);
    }

    // Metodo GET que busca un turno por id
    @GetMapping("/{id}")
    public ResponseEntity<TurnoSalidaDTO> buscarTurno(@Valid @PathVariable Long id) {
        return new ResponseEntity<>(turnoService.buscarTurnoPorId(id), HttpStatus.OK);
    }

    // Metodo Get que lista todos los turnos
    @GetMapping
    public ResponseEntity<List<TurnoSalidaDTO>> listarTurnos() {
        return new ResponseEntity<>(turnoService.listarTurnos(), HttpStatus.OK);
    }

    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<Void> eliminarTurno(@PathVariable Long id) {
        turnoService.eliminarTurno(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
