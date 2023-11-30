package com.atividade2.domain.dto;

import java.util.UUID;

import com.atividade2.domain.entity.AlunoModel;
import com.atividade2.domain.entity.TurmaModel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MatriculaDTO {

    @NotNull
    private UUID id;
    @NotBlank
    private AlunoModel aluno;
    @NotBlank
    private TurmaModel turma;

}
