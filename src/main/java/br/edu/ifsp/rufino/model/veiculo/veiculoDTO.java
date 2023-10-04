package br.edu.ifsp.rufino.model.veiculo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record veiculoDTO(
        @NotBlank
        String marca,
        @NotBlank
        String modelo,
        @NotBlank
        @Pattern(regexp = "\\d{4}")
        String ano,
        String cor) {
}
