package com.atividade2.domain.entity;

import org.hibernate.validator.constraints.UniqueElements;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Table(name = "turmas")
@Entity
public class TurmaModel {

    @EmbeddedId
    @NotNull
    private IdTurma id;
    
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private Integer vagas_minimas;
    @Column(nullable = false)
    private Integer vagas_maximas;
    
}
