package br.edu.ifsp.rufino.model.conserto;

import br.edu.ifsp.rufino.model.mecanico.mecanicoDTO;
import br.edu.ifsp.rufino.model.veiculo.veiculoDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record consertoDTO(
        @NotBlank
        @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}")
        String dataentrada,
        @NotBlank
        @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}")
        String datasaida,
        @Valid
        mecanicoDTO mecanico,
        @Valid
        veiculoDTO veiculo
) {
}
