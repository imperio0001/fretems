package com.fretems.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor //construtor public Cliente(String nome, String email) this.nome = nome; this.email = email}
@NotNull(message = "Dado é obrigatório")
public class ClienteRequestDTO {

    @NotNull(message = "Nome é obrigatório")
    private String nomeCliente;
    @NotNull(message = "Telefone é obrigatório")
    private String telefoneCliente;
    @NotNull(message = "Documento é obrigatório")
    private String documentoCliente;

}
