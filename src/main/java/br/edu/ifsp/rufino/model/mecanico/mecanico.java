package br.edu.ifsp.rufino.model.mecanico;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
// Veiculo e Mecanico “embedded” em Conserto (como visto na aula)
@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class mecanico {
    public String nome;
    public int experiencia;
    public mecanico(mecanicoDTO dados){
        this.nome = dados.nome();
        this.experiencia = dados.experiencia();
    }

    public void atualizar(mecanicoDTO mecanico) {
        if (mecanico.nome() != null)
            this.nome = mecanico.nome();
        if (mecanico.experiencia() != this.experiencia)
            this.experiencia = mecanico.experiencia();
    }
}
