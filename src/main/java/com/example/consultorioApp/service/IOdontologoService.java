package com.example.consultorioApp.service;

import com.example.consultorioApp.model.Odontologo;
import java.util.List;
import java.util.Optional;

public interface IOdontologoService {

    Odontologo registrarOdontologo(Odontologo odontologo);

    Odontologo actualizarOdontologo(Odontologo odontologoModificado);

    Optional<Odontologo> buscarOdontologo(Long id);

    List<Odontologo> listarOdontologos();

    void eliminarOdontologo(Long id);

}
