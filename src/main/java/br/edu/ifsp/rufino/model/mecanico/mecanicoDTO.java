package br.edu.ifsp.rufino.model.mecanico;

import jakarta.validation.constraints.NotBlank;

public record mecanicoDTO(
        @NotBlank
        String nome,

        int experiencia
) {
}
