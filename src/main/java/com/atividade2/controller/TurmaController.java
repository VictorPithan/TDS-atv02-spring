package com.atividade2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atividade2.domain.dto.TurmaDTO;
import com.atividade2.domain.entity.IdTurma;
import com.atividade2.domain.entity.TurmaModel;
import com.atividade2.service.TurmaService;

import jakarta.validation.Valid;

@Validated
@RequestMapping("/api/v1/turmas")
@RestController
public class TurmaController {

    @Autowired
    private TurmaService turmaService;


    @GetMapping
    public ResponseEntity<List<TurmaDTO>> getTurmas() {
        return ResponseEntity.ok(turmaService.findAll());
    }

    // @GetMapping("/{id}")
    // public ResponseEntity<Object> getTurma(@PathVariable(value = "id") IdTurma id) {
    //     // return ResponseEntity.ok(turmaService.findAll());
    // }

    @PostMapping
    public ResponseEntity salvarAluno(@RequestBody @Valid TurmaDTO turma) {
        TurmaModel turmaModel = turmaService.save(turma);

        return ResponseEntity.ok().body("Turma criada com sucesso!");
    }
    
}
