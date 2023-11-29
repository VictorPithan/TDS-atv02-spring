package com.atividade2.domain.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AlunoDTO {

    private String id;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    private String email;
    @NotBlank
    private String cpf;

}
