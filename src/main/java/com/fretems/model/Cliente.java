package com.fretems.model;

import jakarta.persistence.*;
import lombok.*;

@Entity //entidade banco de dados
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor //construtor public Cliente(String nome, String email) this.nome = nome; this.email = email}
@Builder
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //
    private Long id;

    private String nomeCliente;

    private String telefoneCliente;

    private String documentoCliente;
}
