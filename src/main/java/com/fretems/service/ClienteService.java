package com.fretems.service;

import com.fretems.dto.ClienteRequestDTO;
import com.fretems.dto.ClienteResponseDTO;
import com.fretems.model.Cliente;
import com.fretems.repository.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ClienteResponseDTO cadastraCliente(ClienteRequestDTO request){

        Cliente cliente = Cliente.builder()
                .nomeCliente(request.getNomeCliente())
                .documentoCliente(request.getTelefoneCliente())
                .documentoCliente(request.getDocumentoCliente())
                .build();

        Cliente salvo = clienteRepository.save(cliente);
        return new ClienteResponseDTO(salvo.getId(), salvo.getNomeCliente(), salvo.getTelefoneCliente(), salvo.getDocumentoCliente());
    }
}
