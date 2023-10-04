package br.edu.ifsp.rufino.model.relatorio;

import br.edu.ifsp.rufino.model.conserto.conserto;

public record relatorio(
        String dataentrada,
        String datasaida,
        String nome,
        String marca,
        String modelo
        ) {
    public relatorio (conserto conserto){
        this(conserto.getDataentrada(),
                conserto.getDatasaida(),
                conserto.getMecanicoResponsavel().getNome(),
                conserto.getVeiculo().getMarca(),
                conserto.getVeiculo().getModelo());
    }
}
