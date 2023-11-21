package com.example.consultorioApp.controller;

import com.example.consultorioApp.dto.request.odontologo.OdontologoEntradaDTO;
import com.example.consultorioApp.dto.request.update.OdontologoActualizadoEntradaDTO;
import com.example.consultorioApp.dto.response.odontologo.OdontologoSalidaDTO;
import com.example.consultorioApp.exception.BadRequestException;
import com.example.consultorioApp.exception.ResourceNotFoundException;
import com.example.consultorioApp.service.impl.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    private final OdontologoService odontologoService;

    @Autowired
    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    // Metodo POST que registra un odontologo
    @PostMapping("registrar")
    public ResponseEntity<OdontologoSalidaDTO> registrarOdontologo(@Valid @RequestBody OdontologoEntradaDTO odontologo) {
        return new ResponseEntity<>(odontologoService.registrarOdontologo(odontologo), HttpStatus.CREATED);
    }

    // Metodo PUT que modifica un odontologo
    @PutMapping("actualizar")
    public ResponseEntity<OdontologoSalidaDTO> actualizarOdontologo(@Valid @RequestBody OdontologoActualizadoEntradaDTO odontologo) throws BadRequestException {
        return new ResponseEntity<>(odontologoService.actualizarOdontologo(odontologo), HttpStatus.OK);

    }

    // Metodo GET que busca un odontologo por id
    @GetMapping("/{id}")
    public ResponseEntity<OdontologoSalidaDTO> buscarOdontologo(@PathVariable Long id) throws BadRequestException {
        return new ResponseEntity<>(odontologoService.buscarOdontologo(id), HttpStatus.OK);
    }

    // Metodo GET para listar todos los odontologos
    @GetMapping
    public ResponseEntity<List<OdontologoSalidaDTO>> listarOdontologos() {
        return new ResponseEntity<>(odontologoService.listarOdontologos(), HttpStatus.OK);
    }

    // Metodo DELETE para eliminar un odontologo por id
    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<Void> eliminarOdontologo(@PathVariable Long id) throws ResourceNotFoundException {
        odontologoService.eliminarOdontologo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
