package com.fretems.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor //construtor public Cliente(String nome, String email) this.nome = nome; this.email = email}
public class ClienteRequestDTO {

    private String nomeCliente;
    private String telefoneCliente;
    private String documentoCliente;

}
