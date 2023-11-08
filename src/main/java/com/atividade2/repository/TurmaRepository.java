package com.atividade2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.atividade2.domain.entity.IdTurma;
import com.atividade2.domain.entity.TurmaModel;

public interface TurmaRepository extends JpaRepository<TurmaModel, IdTurma> {

  List<TurmaModel> findAll();

  @Query("SELECT t FROM TurmaModel t WHERE t.id.ano = :ano")
  List<TurmaModel> findAllByAno(@Param("ano") Integer ano);

  @Query("SELECT t FROM TurmaModel t WHERE t.id.sigla = :sigla")
  List<TurmaModel> findAllBySigla(@Param("sigla") String sigla);

}
