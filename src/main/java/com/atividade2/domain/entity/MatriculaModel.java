package com.atividade2.domain.entity;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "matriculas")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class MatriculaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    @JsonIgnoreProperties("matricula")
    private AlunoModel aluno;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "turma_sigla", referencedColumnName = "sigla"),
        @JoinColumn(name = "turma_ano", referencedColumnName = "ano"),
        @JoinColumn(name = "turma_semestre", referencedColumnName = "semestre")
    })
    @JsonIgnoreProperties("matricula")
    private TurmaModel turma;
}
