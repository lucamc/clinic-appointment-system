package com.example.consultorioApp.service.impl;

import com.example.consultorioApp.exception.ResourceNotFoundException;
import com.example.consultorioApp.model.Odontologo;
import com.example.consultorioApp.repository.IOdontologoRepository;
import com.example.consultorioApp.service.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OdontologoService implements IOdontologoService {


    @Autowired
    private final IOdontologoRepository odontologoRepository;


    public OdontologoService(IOdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    @Override
    public OdontologoDTO registrarOdontologo(OdontologoDTO odontologoDTO) {
        Odontologo odontologo = convertirAEntidad(odontologoDTO);
        Odontologo nuevoOdontologo = odontologoRepository.save(odontologo);
        return convertirADTO(nuevoOdontologo);
    }


    @Override
    public OdontologoDTO actualizarOdontologo(OdontologoDTO odontologoDTO) {
        Odontologo odontologoExistente = odontologoRepository.findById(odontologoDTO.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Odontologo no encontrado"));
        odontologoExistente.setNombre(odontologoDTO.getNombre());
        odontologoExistente.setApellido(odontologoDTO.getApellido());
        odontologoExistente.setMatricula(odontologoDTO.getMatricula());
        odontologoRepository.save(odontologoExistente);
        return convertirADTO(odontologoExistente);
    }


    @Override
    public Optional<OdontologoDTO> buscarOdontologo(Long id) {
        Optional<Odontologo> odontologo = Optional.ofNullable(odontologoRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Odontologo no encontrado")));
        return odontologo.map(this::convertirADTO);
    }

    @Override
    public List<OdontologoDTO> listarOdontologos() {
        List<Odontologo> odontologos = odontologoRepository.findAll();
        return odontologos.stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    @Override
    public void eliminarOdontologo(Long id) {
        odontologoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Odontologo no encontrado"));
        odontologoRepository.deleteById(id);
    }


    // Método para convertir una entidad a DTO
    private OdontologoDTO convertirADTO(Odontologo odontologo) {
        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setId(odontologo.getId());
        odontologoDTO.setNombre(odontologo.getNombre());
        odontologoDTO.setApellido(odontologo.getApellido());
        odontologoDTO.setMatricula(odontologo.getMatricula());
        return odontologoDTO;
    }

    // Método para convertir un DTO a una entidad
    private Odontologo convertirAEntidad(OdontologoDTO odontologoDTO) {
        Odontologo odontologo = new Odontologo();
        // No asignamos el ID aquí si estamos creando una nueva entidad, solo en actualizaciones.
        odontologo.setNombre(odontologoDTO.getNombre());
        odontologo.setApellido(odontologoDTO.getApellido());
        odontologo.setMatricula(odontologoDTO.getMatricula());
        return odontologo;
    }

}

