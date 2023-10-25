package br.edu.ifsp.rufino.persistence;
import br.edu.ifsp.rufino.model.conserto.conserto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Range;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsertoRepository extends JpaRepository<conserto, Long> {
    Page<conserto> findAllByAtivoTrue(Pageable pagina);
}
