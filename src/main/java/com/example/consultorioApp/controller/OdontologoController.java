package com.example.consultorioApp.controller;

import com.example.consultorioApp.service.impl.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    private final OdontologoService odontologoService;

    @Autowired
    public OdontologoController (OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    // Metodo POST que registra un odontologo
    @PostMapping("registrar")
    public ResponseEntity<OdontologoDTO> registrarOdontologo(@Valid @RequestBody OdontologoDTO odontologo) {
        OdontologoDTO odontologoRegistrado = odontologoService.registrarOdontologo(odontologo);
        return ResponseEntity.status(HttpStatus.CREATED).body(odontologoRegistrado);
    }

    // Metodo PUT que modifica un odontologo
    @PutMapping("actualizar")
    public ResponseEntity<OdontologoDTO> actualizarOdontologo(@Valid @RequestBody OdontologoDTO odontologo) {

        // Si el odontologo no existe, devuelve un status 404
        if (odontologoService.buscarOdontologo(odontologo.getId()).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            // Si el odontologo existe, devuelve el odontologo actualizado
            OdontologoDTO odontologoActualizado = odontologoService.actualizarOdontologo(odontologo);
            return ResponseEntity.ok(odontologoActualizado);
        }
    }

    // Metodo GET que busca un odontologo por id
    @GetMapping("/{id}")
    public ResponseEntity<OdontologoDTO> buscarOdontologo(@PathVariable Long id) {
        OdontologoDTO odontologo = odontologoService.buscarOdontologo(id).orElse(null);
        return ResponseEntity.ok(odontologo);
    }

    // Metodo GET para listar todos los odontologos
    @GetMapping
    public ResponseEntity<List<OdontologoDTO>> listarOdontologos() {
        List<OdontologoDTO> odontologos = odontologoService.listarOdontologos();
        return ResponseEntity.ok(odontologos);
    }

    // Metodo DELETE para eliminar un odontologo por id
    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<String> eliminarOdontologo(@PathVariable Long id) {
        Optional<OdontologoDTO> odontologo = odontologoService.buscarOdontologo(id);

        // Si el odontologo no existe, devuelve un status 404
        if (odontologo.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El odontologo no existe");

        } else {
            // Si el odontologo existe, lo elimina y devuelve un status 204
            odontologoService.eliminarOdontologo(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

}
