package com.atividade2.domain.dto;


import com.atividade2.domain.entity.IdTurma;

import lombok.Data;

@Data
public class TurmaDTO {
  
    private IdTurma id;
    private String sigla; 
    private Integer ano;
    private Integer semestre;
    private String nome;
    private Integer vagas_minimas;
    private Integer vagas_maximas;
}
    

