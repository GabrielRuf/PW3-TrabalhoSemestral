package br.edu.ifsp.rufino.model.conserto;

import br.edu.ifsp.rufino.model.mecanico.mecanicoDTO;
import br.edu.ifsp.rufino.model.veiculo.veiculoDTO;

public record consertoDTO(String dataentrada, String datasaida, mecanicoDTO mecanico, veiculoDTO veiculo) {
}
