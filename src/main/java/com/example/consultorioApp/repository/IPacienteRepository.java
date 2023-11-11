package com.example.consultorioApp.repository;


import com.example.consultorioApp.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente, Long> {

    /**
     * Encuentra un paciente por su DNI.
     * El DNI es único para cada paciente, por lo que se espera que este método devuelva como máximo un paciente.
     *
     * @param dni El DNI del paciente a buscar.
     * @return Un Optional que contiene el paciente encontrado o vacío si no se encontró ninguno.
     */
    Optional<Paciente> findByDni(String dni);


    /**
     * Encuentra pacientes cuyo apellido contenga la cadena proporcionada, ignorando mayúsculas y minúsculas.
     * Esto es útil para búsquedas insensibles a mayúsculas y minúsculas y cuando no se conoce el apellido completo.
     *
     * @param apellido El apellido o parte del mismo para buscar entre los pacientes.
     * @return Una lista de pacientes cuyos apellidos contienen la cadena proporcionada.
     */
    List<Paciente> findByApellidoContainingIgnoreCase(String apellido);
}
