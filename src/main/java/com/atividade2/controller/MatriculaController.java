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
import org.springframework.web.bind.annotation.RestController;

import com.atividade2.domain.dto.AlunoDTO;
import com.atividade2.domain.dto.MatriculaDTO;
import com.atividade2.domain.entity.AlunoModel;
import com.atividade2.service.AlunoService;
import com.atividade2.service.MatriculaService;


@Validated
@RequestMapping("/api/v1/turmas/matriculas")
@RestController
public class MatriculaController {
    
    @Autowired
    private MatriculaService matriculaService;

    @GetMapping
    public ResponseEntity<List<MatriculaDTO>> getAlunos() {

        return ResponseEntity.ok(matriculaService.findAll());
    }

    // @GetMapping("/{id}")
    // public ResponseEntity<Object> getAluno(@PathVariable (value = "id")String id) {
        
    //     Optional<AlunoModel> alunoModelOptional = alunoService.findById(id);
    //     return ResponseEntity.ok(alunoModelOptional.get());
    // }

    // @PostMapping
    // public ResponseEntity<Object> salvarTurma(@RequestBody @Validated AlunoDTO aluno) {
    //     return ResponseEntity.ok().body(alunoService.save(aluno));
    // }
}
