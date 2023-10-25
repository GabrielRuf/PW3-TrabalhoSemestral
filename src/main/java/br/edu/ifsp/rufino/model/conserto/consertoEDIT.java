package br.edu.ifsp.rufino.model.conserto;

import br.edu.ifsp.rufino.model.mecanico.mecanicoDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record consertoEDIT(
        @NotNull
        Long id,
        @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}")
        String datasaida,
        mecanicoDTO mecanico

) {
}
