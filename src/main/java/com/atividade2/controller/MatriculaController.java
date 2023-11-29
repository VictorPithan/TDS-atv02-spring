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
import com.atividade2.domain.dto.MatriculaDTO;
import com.atividade2.domain.entity.AlunoModel;
import com.atividade2.domain.entity.IdTurma;
import com.atividade2.domain.entity.MatriculaModel;
import com.atividade2.domain.entity.TurmaModel;
import com.atividade2.service.AlunoService;
import com.atividade2.service.MatriculaService;
import com.atividade2.service.TurmaService;


@Validated
@RequestMapping("/api/v1")
@RestController
public class MatriculaController {
    
    @Autowired
    private MatriculaService matriculaService;
    
    @Autowired
    private AlunoService alunoService;

    @Autowired
    private TurmaService turmaService;

    @GetMapping("/matriculas")
    public ResponseEntity<List<MatriculaDTO>> getMatriculas() {
        return ResponseEntity.ok(matriculaService.findAll());
    }

    // @GetMapping("/{id}")
    // public ResponseEntity<Object> getAluno(@PathVariable (value = "id")String id) {
        
    //     Optional<AlunoModel> alunoModelOptional = alunoService.findById(id);
    //     return ResponseEntity.ok(alunoModelOptional.get());
    // }

    @PostMapping("/alunos/{id}/matriculas")
    public ResponseEntity<Object> salvarTurma(@PathVariable (value = "id") UUID id, @RequestBody IdTurma idTurma) {
        MatriculaDTO matricula = new MatriculaDTO();
        AlunoModel aluno;
        TurmaModel turma;

        System.out.println("ID TURMA => " + idTurma);

        aluno = alunoService.findById(id).get();
        turma = turmaService.findById(idTurma).get();

        System.out.println("TURMA => " + turma);
        System.out.println("ALUNO => " + aluno);

        matricula.setAluno(aluno);
        matricula.setTurma(turma);
        return ResponseEntity.ok().body(matriculaService.matricular(matricula));
    }
}
