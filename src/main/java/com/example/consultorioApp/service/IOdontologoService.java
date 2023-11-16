package com.example.consultorioApp.service;

import java.util.List;
import java.util.Optional;

public interface IOdontologoService {

    OdontologoDTO registrarOdontologo(OdontologoDTO odontologoDTO);

    OdontologoDTO actualizarOdontologo(OdontologoDTO odontologoActualizadoDTO);

    Optional<OdontologoDTO> buscarOdontologo(Long id);

    List<OdontologoDTO> listarOdontologos();

    void eliminarOdontologo(Long id);

}
