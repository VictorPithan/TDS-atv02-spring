package com.atividade2.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atividade2.domain.dto.AlunoDTO;
import com.atividade2.domain.entity.AlunoModel;
import com.atividade2.repository.AlunoRepository;

@Service
public class AlunoService {
    
    @Autowired
    AlunoRepository alunoRepository;

    private AlunoDTO converte(AlunoModel aluno) {
        AlunoDTO dto = new AlunoDTO();
        BeanUtils.copyProperties(aluno, dto);
        return dto;
    }

    public List<AlunoDTO> findAll() {
        return alunoRepository.findAll().stream()
            .map(this::converte)
            .collect(Collectors.toList());
    }

    public Optional<AlunoModel> findById(UUID id) {
        return alunoRepository.findById(id);
    }

    public AlunoModel save(AlunoDTO alunoDTO) {
        AlunoModel alunoModel = new AlunoModel();
        
        alunoModel.setNome(alunoDTO.getNome());
        alunoModel.setSobrenome(alunoDTO.getSobrenome());
        alunoModel.setCpf(alunoDTO.getCpf());
        alunoModel.setEmail(alunoDTO.getEmail());
        

        return alunoRepository.save(alunoModel);
    }


}
