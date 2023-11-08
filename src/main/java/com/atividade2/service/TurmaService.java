package com.atividade2.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atividade2.domain.dto.TurmaDTO;
import com.atividade2.domain.entity.IdTurma;
import com.atividade2.domain.entity.TurmaModel;
import com.atividade2.repository.TurmaRepository;
import com.atividade2.service.exceptions.NotFoundException;

@Service
public class TurmaService {

    @Autowired
    TurmaRepository turmaRepository;

    private TurmaDTO converte(TurmaModel turma) {
        TurmaDTO dto = new TurmaDTO();
        BeanUtils.copyProperties(turma, dto);
        return dto;
    }
    
    public List<TurmaDTO> findAll() {

        return turmaRepository.findAll().stream()
            .map(this::converte)
            .collect(Collectors.toList());
    }

    public List<TurmaDTO> findAllByAno(Integer ano) {

        List<TurmaModel> turmaFilteredByAno = turmaRepository.findAllByAno(ano);

        if (turmaFilteredByAno.isEmpty()) {
            throw new NotFoundException("Não foram encontradas turmas deste ano");
        }

        return turmaFilteredByAno.stream()
            .map(this::converte)
            .collect(Collectors.toList());
    }

    public List<TurmaDTO> findAllBySigla(String sigla) {

        List<TurmaModel> turmaFilteredBySigla = turmaRepository.findAllBySigla(sigla);

        if (turmaFilteredBySigla.isEmpty()) {
            throw new NotFoundException("Não for encontradas turmas com esta sigla");
        }
        
        return turmaFilteredBySigla.stream()
            .map(this::converte)
            .collect(Collectors.toList());
    }

    public TurmaModel save(TurmaDTO turmaDTO) {
        TurmaModel turmaModel = new TurmaModel();
        IdTurma idTurma = new IdTurma(turmaDTO.getId().getSigla(), turmaDTO.getId().getAno(), turmaDTO.getId().getSemestre());
        turmaModel.setNome(turmaDTO.getNome());
        turmaModel.setVagas_minimas(turmaDTO.getVagas_minimas());
        turmaModel.setVagas_maximas(turmaDTO.getVagas_maximas());
        turmaModel.setId(idTurma);

        return turmaRepository.save(turmaModel);
    }

    public Optional<TurmaModel> findById(IdTurma id) {
        return turmaRepository.findById(id);
    }
    
}
