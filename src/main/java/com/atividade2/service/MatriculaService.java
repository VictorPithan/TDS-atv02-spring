package com.atividade2.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atividade2.domain.dto.MatriculaDTO;
import com.atividade2.domain.entity.MatriculaModel;
import com.atividade2.repository.MatriculaRepository;

@Service
public class MatriculaService {

    @Autowired
    MatriculaRepository matriculaRepository;

    private MatriculaDTO converte(MatriculaModel aluno) {
        MatriculaDTO dto = new MatriculaDTO();
        BeanUtils.copyProperties(aluno, dto);
        return dto;
    }

    public List<MatriculaDTO> findAll() {
        return matriculaRepository.findAll().stream()
                .map(this::converte)
                .collect(Collectors.toList());
    }

    // public Optional<AlunoModel> findById(String id) {
    // return alunoRepository.findById(id);
    // }

    public MatriculaModel matricular(MatriculaDTO matriculaDTO) {
        MatriculaModel matriulaModel = new MatriculaModel();

        matriulaModel.setAluno(matriculaDTO.getAluno());
        matriulaModel.setTurma(matriculaDTO.getTurma());

        return matriculaRepository.save(matriulaModel);
    }

    public MatriculaModel findById(UUID id) {
        return matriculaRepository.findById(id).get();
    }

}
