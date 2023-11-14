package com.example.consultorioApp.service.impl;

import com.example.consultorioApp.model.Odontologo;
import com.example.consultorioApp.repository.IOdontologoRepository;
import com.example.consultorioApp.service.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService implements IOdontologoService {


    @Autowired
    private final IOdontologoRepository odontologoRepository;


    // Constructor de la clase OdontologoService
    public OdontologoService(IOdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    // Metodo que agrega un odontologo
    @Override
    public Odontologo registrarOdontologo(Odontologo odontologo) {
        return odontologoRepository.save(odontologo);
    }

    @Override
    public Odontologo actualizarOdontologo(Odontologo odontologoModificado) {
        return odontologoRepository.save(odontologoModificado);
    }

    // Metodo que busca un odontologo por id
    @Override
    public Optional<Odontologo> buscarOdontologo(Long id) {
        return odontologoRepository.findById(id);
    }

    // Metodo que lista todos los odontologos
    @Override
    public List<Odontologo> listarOdontologos() {
        return odontologoRepository.findAll();
    }

    // Metodo que elimina un odontologo por id
    @Override
    public void eliminarOdontologo(Long id) {
        odontologoRepository.deleteById(id);
    }

}
