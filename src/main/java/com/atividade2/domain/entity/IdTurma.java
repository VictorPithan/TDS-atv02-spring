package com.atividade2.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IdTurma {
    @Column(nullable = false)
    private String sigla;
    @Column(nullable = false)
    private Integer ano;
    @Column(nullable = false)
    private Integer semestre;
}
