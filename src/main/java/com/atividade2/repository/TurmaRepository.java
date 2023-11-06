package com.atividade2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atividade2.domain.entity.IdTurma;
import com.atividade2.domain.entity.TurmaModel;

public interface TurmaRepository extends JpaRepository<TurmaModel, IdTurma> {    

  List<TurmaModel> findAll();
  
}

