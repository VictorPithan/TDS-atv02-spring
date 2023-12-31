package com.atividade2.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atividade2.domain.dto.TurmaDTO;
import com.atividade2.domain.entity.IdTurma;
import com.atividade2.domain.entity.TurmaModel;
import com.atividade2.service.TurmaService;

@Validated
@RequestMapping("/api/v1/turmas")
@RestController
public class TurmaController {

    @Autowired
    private TurmaService turmaService;


    @GetMapping
    public ResponseEntity<List<TurmaDTO>> getTurmas(@RequestParam(required = false) Optional<Integer> ano, @RequestParam(required = false) Optional<String> sigla) {
        if (ano.isPresent()) {
            return ResponseEntity.ok(turmaService.findAllByAno(ano.get()));
        }

        if (sigla.isPresent()) {
            return ResponseEntity.ok(turmaService.findAllBySigla(sigla.get()));
        }

        return ResponseEntity.ok(turmaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getTurma(@PathVariable(value = "id") String id) {
        var idTurmaAux = id.split("-");
        IdTurma idTurma = new IdTurma(idTurmaAux[0], Integer.parseInt(idTurmaAux[1]), Integer.parseInt(idTurmaAux[2]));
        Optional<TurmaModel> turmaModelOptional = turmaService.findById(idTurma);

        if (!turmaModelOptional.isPresent()) {
            
        }

        return ResponseEntity.ok(turmaModelOptional.get());
    }

    @PostMapping
    public ResponseEntity<Object> salvarTurma(@RequestBody @Validated TurmaDTO turma) {   
        return ResponseEntity.ok().body(turmaService.save(turma));
    }



    

    // POST MATRICULAS
    // POST ALUNOS
    // VALIDATION
    
}
