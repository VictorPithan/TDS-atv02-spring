package com.atividade2.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atividade2.domain.entity.AlunoModel;

public interface AlunoRepository extends JpaRepository<AlunoModel, UUID> {

    List<AlunoModel> findAll();

}