package com.example.consultorioApp.service;

import com.example.consultorioApp.dto.request.odontologo.OdontologoEntradaDTO;
import com.example.consultorioApp.dto.request.update.OdontologoActualizadoEntradaDTO;
import com.example.consultorioApp.dto.response.odontologo.OdontologoSalidaDTO;

import java.util.List;
import java.util.Optional;

public interface IOdontologoService {

    OdontologoSalidaDTO registrarOdontologo(OdontologoEntradaDTO odontologo);

    OdontologoSalidaDTO actualizarOdontologo(OdontologoActualizadoEntradaDTO odontologo);

    OdontologoSalidaDTO buscarOdontologo(Long id);

    List<OdontologoSalidaDTO> listarOdontologos();

    void eliminarOdontologo(Long id);

}
