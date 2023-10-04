package br.edu.ifsp.rufino.model.veiculo;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

// Veiculo e Mecanico “embedded” em Conserto (como visto na aula)
@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class veiculo {
    private String marca;
    private String modelo;
    private String ano;
    private String cor;
    public veiculo (veiculoDTO dados){
        this.marca = dados.marca();
        this.modelo = dados.modelo();
        this.ano = dados.ano();
    }
}
