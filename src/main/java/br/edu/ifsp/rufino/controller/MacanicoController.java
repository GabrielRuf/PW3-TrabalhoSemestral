package br.edu.ifsp.rufino.controller;

import br.edu.ifsp.rufino.model.conserto.conserto;
import br.edu.ifsp.rufino.model.conserto.consertoDTO;
import br.edu.ifsp.rufino.model.relatorio.relatorio;
import br.edu.ifsp.rufino.persistence.ConsertoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("conserto")
public class MacanicoController {
    @Autowired
    private ConsertoRepository repository;
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid consertoDTO conserto){
        repository.save(new conserto(conserto));
    }
    @GetMapping
    public Page<conserto> findAll(Pageable pagina){
        return repository.findAll(pagina);
    }
    @GetMapping
    @RequestMapping("relatorio")
    public Page<relatorio> getRelatorio(Pageable pagina){
        return repository.findAll(pagina).map(relatorio::new);
    }
}
