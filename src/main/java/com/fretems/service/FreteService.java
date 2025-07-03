package com.fretems.service;

import com.fretems.dto.FreteRequestDTO;
import com.fretems.dto.FreteResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class FreteService {

    public FreteResponseDTO calcularFrete(FreteRequestDTO request) {

        validarEntrada(request);
        double valorFrete;
        String tipo = request.getTipoTransporte().trim().toLowerCase();

        valorFrete = switch (tipo) {
            case "normal" -> calcularNormal(request);
            case "expresso" -> calcularExpresso(request);
            default ->
                    throw new IllegalArgumentException("Tipo de transporte inválido: " + request.getTipoTransporte());
        };
        return new FreteResponseDTO(valorFrete);

    }
    private void validarEntrada(FreteRequestDTO request) {
        if (request.getPeso() == null || request.getPeso() < 0) {
            throw new IllegalArgumentException("Peso deve ser maior ou igual a zero");
        }
        if (request.getDistancia() == null || request.getDistancia() < 0) {
            throw new IllegalArgumentException("Distância deve ser maior ou igual a zero");
        }
        if (request.getTipoTransporte() == null || request.getTipoTransporte().isBlank()) {
            throw new IllegalArgumentException("Tipo de transporte é obrigatório");
        }
    }
    private double calcularNormal(FreteRequestDTO request) {
        return 5.0 + (0.5 * request.getDistancia()) + (2.0 * request.getPeso());
    }
    private double calcularExpresso(FreteRequestDTO request) {
        return 10.0 + (1.0 * request.getDistancia()) + (5.0 * request.getPeso());
    }
}
