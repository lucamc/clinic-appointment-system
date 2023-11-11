package com.example.consultorioApp.repository;

import com.example.consultorioApp.model.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOdontologoRepository extends JpaRepository<Odontologo, Long> {

    /**
     * Encuentra odontólogos por su matrícula profesional.
     * La búsqueda por matrícula se asume que es única, por lo que debería devolver un único resultado.
     *
     * @param matricula la matrícula profesional del odontólogo a buscar.
     * @return una lista de odontólogos que coinciden con la matrícula proporcionada.
     */
    List<Odontologo> findByMatricula(String matricula);

    /**
     * Encuentra odontólogos cuyo apellido contenga la cadena proporcionada, ignorando mayúsculas y minúsculas.
     * Esto es útil para búsquedas insensibles a mayúsculas y minúsculas y para cuando no se conoce el apellido completo.
     *
     * @param apellido el apellido o parte de él para buscar entre los odontólogos.
     * @return una lista de odontólogos cuyos apellidos contienen la cadena proporcionada.
     */
    List<Odontologo> findByApellidoContainingIgnoreCase(String apellido);

}
