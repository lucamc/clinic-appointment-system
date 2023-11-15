package com.example.consultorioApp.dto;

import com.example.consultorioApp.model.Domicilio;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class DomicilioDTO implements Serializable {

    private Long id;
    private String calle;
    private String numero;
    private String localidad;

    // Constructores
    public DomicilioDTO() {
    }

    public DomicilioDTO(Long id, String calle, String numero, String localidad) {
        this.id = id;
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
    }

    public static DomicilioDTO convertirADTO(Domicilio domicilio) {
        DomicilioDTO domicilioDTO = new DomicilioDTO();
        domicilioDTO.setId(domicilio.getId());
        domicilioDTO.setCalle(domicilio.getCalle());
        domicilioDTO.setNumero(domicilio.getNumero());
        domicilioDTO.setLocalidad(domicilio.getLocalidad());
        return domicilioDTO;
    }

    public static Domicilio convertirEntidad(DomicilioDTO domicilioDTO) {
        Domicilio domicilio = new Domicilio();
        domicilio.setCalle(domicilioDTO.getCalle());
        domicilio.setNumero(domicilioDTO.getNumero());
        domicilio.setLocalidad(domicilioDTO.getLocalidad());
        return domicilio;
    }


    @Override
    public String toString() {
        return "DomicilioDTO{" +
                "id=" + id +
                ", calle='" + calle + '\'' +
                ", numero='" + numero + '\'' +
                ", localidad='" + localidad + '\'' +
                '}';
    }
}
