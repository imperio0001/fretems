package com.fretems.service;

import com.fretems.model.FreteRequestDTO;
import com.fretems.model.FreteResponseDTO;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FreteServiceTest {
    private final FreteService freteService = new FreteService();

    @Test
    public void testCalculoFreteNormal() {
        FreteRequestDTO request = new FreteRequestDTO();
        request.setPeso(10.0);
        request.setDistancia(100.0);
        request.setTipoTransporte("Normal");

        FreteResponseDTO response = freteService.calcularFrete(request);

        double expected = 5.0 + (0.5 * 100.0) + (2.0 * 10.0); // 5 + 50 + 20 = 75
        assertEquals(expected, response.getValorFrete());
    }

    @Test
    public void testcalcularExpresso() {
        FreteRequestDTO request = new FreteRequestDTO();
        request.setPeso(50.0);
        request.setDistancia(100.0);
        request.setTipoTransporte("Expresso");

        FreteResponseDTO freteResponseDTO = freteService.calcularFrete(request);

        double expected = 10.0 + (100.0) + (5.0 * 50.0); // 10 + 50 + 25 = 85
        assertEquals(expected, freteResponseDTO.getValorFrete());
    }

    @Test
    public void testPesoNegativo() {
        FreteRequestDTO request = new FreteRequestDTO();
        request.setPeso(-1.0);
        request.setDistancia(50.0);
        request.setTipoTransporte("Normal");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            freteService.calcularFrete(request);
        });

        assertEquals("Peso deve ser maior ou igual a zero", exception.getMessage());
    }

    @Test
    public void testDistanciaNegativa() {
        FreteRequestDTO request = new FreteRequestDTO();
        request.setPeso(5.0);
        request.setDistancia(-10.0);
        request.setTipoTransporte("Normal");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            freteService.calcularFrete(request);
        });

        assertEquals("Distância deve ser maior ou igual a zero", exception.getMessage());
    }

    @Test
    public void testTipoTransporteInvalido() {
        FreteRequestDTO request = new FreteRequestDTO();
        request.setPeso(5.0);
        request.setDistancia(10.0);
        request.setTipoTransporte("UltraRápido");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            freteService.calcularFrete(request);
        });

        assertEquals("Tipo de transporte inválido: UltraRápido", exception.getMessage());
    }
}
