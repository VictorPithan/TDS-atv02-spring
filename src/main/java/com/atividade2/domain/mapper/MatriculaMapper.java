package com.atividade2.domain.mapper;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatriculaMapper {

    // @NotNull
    private String aluno;

    // @NotNull
    private String turma;

    // @NotNull
    private UUID matricula;

    


}
