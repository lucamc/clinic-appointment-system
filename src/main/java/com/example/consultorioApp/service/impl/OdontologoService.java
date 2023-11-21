package com.example.consultorioApp.service.impl;

import com.example.consultorioApp.dto.request.odontologo.OdontologoEntradaDTO;
import com.example.consultorioApp.dto.request.update.OdontologoActualizadoEntradaDTO;
import com.example.consultorioApp.dto.response.odontologo.OdontologoSalidaDTO;
import com.example.consultorioApp.exception.ResourceNotFoundException;
import com.example.consultorioApp.model.Odontologo;
import com.example.consultorioApp.model.Paciente;
import com.example.consultorioApp.repository.IOdontologoRepository;
import com.example.consultorioApp.service.IOdontologoService;
import com.sun.jdi.PrimitiveValue;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OdontologoService implements IOdontologoService {



    private final IOdontologoRepository odontologoRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public OdontologoService(IOdontologoRepository odontologoRepository, ModelMapper modelMapper) {
        this.odontologoRepository = odontologoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public OdontologoSalidaDTO registrarOdontologo(OdontologoEntradaDTO odontologo) {
        Odontologo odontologoIngresado = dtoEntradaAEntidad(odontologo);
        Odontologo odontologoRegistrado = odontologoRepository.save(odontologoIngresado);
        return entidadAdtoSalida(odontologoRegistrado);
    }

    @Override
    public OdontologoSalidaDTO actualizarOdontologo(OdontologoActualizadoEntradaDTO odontologo) {
      // Busca odontologo y lanza una exepcion si no lo encuentra
        Odontologo odontologoActualizar = odontologoRepository.findById(odontologo.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro el odontologo con id: " + odontologo.getId()));

        // Actualiza y guarda el odontologo
        Odontologo odontologoActualizado = dtoActualizadoAEntidad(odontologo);
        odontologoRepository.save(odontologoActualizado);

        // Convierte el odontologo actualizado a DTO y lo retorna
        return entidadAdtoSalida(odontologoActualizado);
    }

    @Override
    public OdontologoSalidaDTO buscarOdontologo(Long id) {
        Odontologo odontologo = odontologoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro el odontologo con id: " + id));
        return entidadAdtoSalida(odontologo);
    }

    @Override
    public List<OdontologoSalidaDTO> listarOdontologos() {
        List<Odontologo> odontologos = odontologoRepository.findAll();
        return odontologos.stream().map(this::entidadAdtoSalida).toList();
    }

    @Override
    public void eliminarOdontologo(Long id) {
        Optional<Odontologo> odontologo = odontologoRepository.findById(id);
        if (odontologo.isEmpty()) {
            throw new ResourceNotFoundException("No se encontro el odontologo con id: " + id);
        }
        odontologoRepository.deleteById(id);
    }


    // Metodos privados
    private OdontologoSalidaDTO entidadAdtoSalida(Odontologo odontologo) {
        return modelMapper.map(odontologo, OdontologoSalidaDTO.class);
    }

    public Odontologo dtoEntradaAEntidad(OdontologoEntradaDTO odontologo) {
        return modelMapper.map(odontologo, Odontologo.class);
    }

    public Odontologo dtoActualizadoAEntidad(OdontologoActualizadoEntradaDTO odontologo) {
        return modelMapper.map(odontologo, Odontologo.class);
    }

    // Método para convertir OdontologoSalidaDTO a entidad
    public Odontologo convertirADTOAEntidad(OdontologoSalidaDTO odontologoDTO) {
        return modelMapper.map(odontologoDTO, Odontologo.class);
    }

}

