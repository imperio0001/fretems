package com.fretems.dto;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class ClienteResponseDTO {

    private Long id;
    private String nomeCliente;
    private String telefoneCliente;
    private String documentoCliente;

}
