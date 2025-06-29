package com.fretems.controller;


import com.fretems.model.FreteRequestDTO;
import com.fretems.model.FreteResponseDTO;
import com.fretems.service.FreteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/frete")
public class FreteController {

    private final FreteService freteService;

    public FreteController(FreteService freteService) {
        this.freteService = freteService;
    }

    @PostMapping("/calcular")
    public ResponseEntity<FreteResponseDTO> calcular(@Valid @RequestBody FreteRequestDTO request) {
        FreteResponseDTO resposta = freteService.calcularFrete(request);
        return ResponseEntity.ok(resposta);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgument(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
