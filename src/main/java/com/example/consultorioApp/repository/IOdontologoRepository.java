package com.example.consultorioApp.repository;

import com.example.consultorioApp.model.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOdontologoRepository extends JpaRepository<Odontologo, Long> {


}
