package com.example.consultorioApp.service;


import com.example.consultorioApp.dto.request.turno.TurnoEntradaDTO;
import com.example.consultorioApp.dto.request.update.TurnoActualizadoEntradaDTO;
import com.example.consultorioApp.dto.response.turno.TurnoSalidaDTO;
import com.example.consultorioApp.exception.BadRequestException;
import com.example.consultorioApp.exception.ResourceNotFoundException;

import java.util.List;

public interface ITurnoService {

    TurnoSalidaDTO registrarTurno(TurnoEntradaDTO turnoEntradaDto) throws BadRequestException, ResourceNotFoundException;

    TurnoSalidaDTO actualizarTurno(TurnoActualizadoEntradaDTO turnoEntradaDto) throws BadRequestException;

    TurnoSalidaDTO buscarTurnoPorId(Long id) throws BadRequestException;

    List<TurnoSalidaDTO> listarTurnos();

    void eliminarTurno(Long id) throws ResourceNotFoundException;


}
