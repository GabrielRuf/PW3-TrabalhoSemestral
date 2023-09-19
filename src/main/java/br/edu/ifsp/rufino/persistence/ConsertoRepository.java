package br.edu.ifsp.rufino.persistence;
import br.edu.ifsp.rufino.model.conserto.conserto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsertoRepository extends JpaRepository<conserto, Long> {
}
