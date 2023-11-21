package com.example.consultorioApp.service;


import com.example.consultorioApp.dto.request.turno.TurnoEntradaDTO;
import com.example.consultorioApp.dto.request.update.TurnoActualizadoEntradaDTO;
import com.example.consultorioApp.dto.response.turno.TurnoSalidaDTO;

import java.util.List;

public interface ITurnoService {

    TurnoSalidaDTO registrarTurno(TurnoEntradaDTO turnoEntradaDto);

    TurnoSalidaDTO actualizarTurno(TurnoActualizadoEntradaDTO turnoEntradaDto);

    TurnoSalidaDTO buscarTurnoPorId(Long id);

    List<TurnoSalidaDTO> listarTurnos();

    void eliminarTurno(Long id);


}
