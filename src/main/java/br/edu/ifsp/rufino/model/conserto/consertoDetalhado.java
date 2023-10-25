package br.edu.ifsp.rufino.model.conserto;

import br.edu.ifsp.rufino.model.mecanico.mecanico;
import br.edu.ifsp.rufino.model.veiculo.veiculo;

public record consertoDetalhado(Long id,
                                String dataentrada,
                                String datasaida,
                                mecanico mecanico,
                                veiculo veiculo
                                ) {
    public consertoDetalhado(conserto conserto){
        this(conserto.getId(),conserto.getDataentrada(),
                conserto.getDatasaida(),conserto.getMecanicoResponsavel(),
                conserto.getVeiculo());
    }
}
