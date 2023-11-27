package com.atividade2.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MatriculaDTO {

    @NotNull
    private String id;
    @NotBlank
    private String aluno;
    @NotBlank
    private String turma;

}
