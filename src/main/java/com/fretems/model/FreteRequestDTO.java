package com.fretems.model;

import jakarta.validation.constraints.*;

public class FreteRequestDTO {
    @NotNull(message = "Peso é obrigatório")
    @Min(value = 0, message = "Peso deve ser maior ou igual a 0")
    private Double peso;

    @NotNull(message = "Distância é obrigatória")
    @Min(value = 0, message = "Distância deve ser maior ou igual a 0")
    private Double distancia;

    @NotBlank(message = "Tipo de transporte é obrigatório")
    private String tipoTransporte;

    // Getters e Setters
    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public String getTipoTransporte() {
        return tipoTransporte;
    }

    public void setTipoTransporte(String tipoTransporte) {
        this.tipoTransporte = tipoTransporte;
    }
}
