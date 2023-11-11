package com.example.consultorioApp.repository;

import com.example.consultorioApp.model.Turno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITurnoRepository extends JpaRepository<Turno, Long> {
}
