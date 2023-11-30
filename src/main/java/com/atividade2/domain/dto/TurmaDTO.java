package com.atividade2.domain.dto;

import com.atividade2.domain.entity.IdTurma;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TurmaDTO {

    @NotNull
    private IdTurma id;
    @NotBlank
    private String nome;
    @NotNull
    @Min(value = 1)
    private Integer vagas_minimas;
    @NotNull
    @Max(value = 20)
    private Integer vagas_maximas;
}
