package com.atividade2.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atividade2.domain.dto.AlunoDTO;
import com.atividade2.domain.entity.AlunoModel;
import com.atividade2.service.AlunoService;


@Validated
@RequestMapping("/api/v1/turmas/alunos")
@RestController
public class AlunoController {
    
    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<AlunoDTO>> getAlunos() {

        return ResponseEntity.ok(alunoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getAluno(@PathVariable (value = "id") UUID id) {
        
        Optional<AlunoModel> alunoModelOptional = alunoService.findById(id);
        return ResponseEntity.ok(alunoModelOptional.get());
    }

    @PostMapping
    public ResponseEntity<Object> salvarTurma(@RequestBody @Validated AlunoDTO aluno) {
        return ResponseEntity.ok().body(alunoService.save(aluno));
    }
}
