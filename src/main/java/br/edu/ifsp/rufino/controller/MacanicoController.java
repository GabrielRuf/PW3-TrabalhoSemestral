package br.edu.ifsp.rufino.controller;

import br.edu.ifsp.rufino.model.conserto.conserto;
import br.edu.ifsp.rufino.model.conserto.consertoDTO;
import br.edu.ifsp.rufino.persistence.ConsertoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("conserto")
public class MacanicoController {
    @Autowired
    private ConsertoRepository repository;
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody consertoDTO conserto){
        repository.save(new conserto(conserto));
    }
}
