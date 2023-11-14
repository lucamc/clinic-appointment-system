package com.example.consultorioApp.service.impl;

import com.example.consultorioApp.model.Turno;
import com.example.consultorioApp.repository.ITurnoRepository;
import com.example.consultorioApp.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoService implements ITurnoService {

    // Atributo de la clase TurnoService
    private final ITurnoRepository turnoRepository;

    // Constructor de la clase TurnoService
    @Autowired
    public TurnoService(ITurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }

    @Override
    public Turno registrarTurno(Turno turno) {
        return turnoRepository.save(turno);
    }

    @Override
    public Turno actualizarTurno(Turno turnoActualizado) {
        return turnoRepository.save(turnoActualizado);
    }

    @Override
    public Optional<Turno> buscarTurno(Long id) {
        return turnoRepository.findById(id);
    }

    @Override
    public List<Turno> listarTurnos() {
        return turnoRepository.findAll();
    }

    @Override
    public void eliminarTurno(Long id) {
        turnoRepository.deleteById(id);
    }
}
