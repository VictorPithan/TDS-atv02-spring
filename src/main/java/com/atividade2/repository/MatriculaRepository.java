package com.atividade2.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atividade2.domain.entity.MatriculaModel;

public interface MatriculaRepository extends JpaRepository<MatriculaModel, UUID> {

    List<MatriculaModel> findAll();

}