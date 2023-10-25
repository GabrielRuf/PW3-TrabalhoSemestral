package br.edu.ifsp.rufino.controller;

import br.edu.ifsp.rufino.model.conserto.conserto;
import br.edu.ifsp.rufino.model.conserto.consertoDTO;
import br.edu.ifsp.rufino.model.conserto.consertoDetalhado;
import br.edu.ifsp.rufino.model.conserto.consertoEDIT;
import br.edu.ifsp.rufino.model.relatorio.relatorio;
import br.edu.ifsp.rufino.persistence.ConsertoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("conserto")
public class MacanicoController {
    @Autowired
    private ConsertoRepository repository;
    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid consertoDTO conserto,
                                    UriComponentsBuilder uriBuilder){
        conserto consertoNovo = new conserto(conserto);
        repository.save(consertoNovo);
        var uri = uriBuilder.path("/conserto/{id}").buildAndExpand(consertoNovo.getId()).toUri();

        return ResponseEntity.created(uri).body(new consertoDetalhado(consertoNovo));
    }
    @GetMapping
    public Page<conserto> findAll(Pageable pagina){
        return repository.findAll(pagina);
    }
    @GetMapping
    @RequestMapping("relatorio")
    public Page<relatorio> getRelatorio(Pageable pagina){
        return repository.findAllByAtivoTrue(pagina).map(relatorio::new);
    }
    @Transactional
    @PutMapping
    public ResponseEntity atualizar(@RequestBody @Valid consertoEDIT dados){
        conserto conserto = repository.getReferenceById(dados.id());
        conserto.atualizar(dados);
        return ResponseEntity.ok(new consertoDetalhado(conserto));
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        conserto conserto =  repository.getReferenceById(id);
        conserto.inativate();
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity getConsertoById(@PathVariable Long id){
        Optional<conserto> consertoOptional = repository.findById(id);
        if (consertoOptional.isPresent()){
            conserto conserto = consertoOptional.get();
            return ResponseEntity.ok(new consertoDetalhado(conserto));
        }
        else
            return ResponseEntity.notFound().build();
    }
}
