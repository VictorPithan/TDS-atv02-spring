package com.atividade2.domain.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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
    
    @OneToMany(mappedBy = "turma")
    @JsonIgnoreProperties("turma")
    private List<MatriculaModel> matricula;
}
