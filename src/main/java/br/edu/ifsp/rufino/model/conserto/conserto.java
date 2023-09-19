package br.edu.ifsp.rufino.model.conserto;
import br.edu.ifsp.rufino.model.mecanico.mecanicoDTO;
import br.edu.ifsp.rufino.model.veiculo.veiculo;
import br.edu.ifsp.rufino.model.mecanico.mecanico;
import br.edu.ifsp.rufino.model.veiculo.veiculoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table(name = "conserto")
@Entity(name = "conserto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class conserto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dataentrada;
    private String datasaida;
    @Embedded
    private mecanico MecanicoResponsavel;
    @Embedded
    private veiculo Veiculo;

    public conserto(consertoDTO conserto){
        this.dataentrada = conserto.dataentrada();
        this.datasaida = conserto.datasaida();
        this.MecanicoResponsavel = new mecanico(conserto.mecanico());
        this.Veiculo = new veiculo(conserto.veiculo());
    }

}
