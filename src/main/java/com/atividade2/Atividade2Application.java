package com.atividade2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.atividade2.domain.entity.AlunoModel;
import com.atividade2.domain.entity.IdTurma;
import com.atividade2.domain.entity.MatriculaModel;
import com.atividade2.domain.entity.TurmaModel;
import com.atividade2.repository.AlunoRepository;
import com.atividade2.repository.MatriculaRepository;
import com.atividade2.repository.TurmaRepository;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class Atividade2Application {

	@Autowired
	AlunoRepository alunoRepository;

	@Autowired
	TurmaRepository turmaRepository;

	@Autowired
	MatriculaRepository matriculaRepository;

	public static void main(String[] args) {
		SpringApplication.run(Atividade2Application.class, args);
	}

	@PostConstruct
	public void seeds () {
		AlunoModel victor = alunoRepository.save(AlunoModel.builder()
		.nome("Victor")
		.cpf("12345678910")
		.email("victor@email.com")
		.sobrenome("Pithan").build()
		);

		AlunoModel isadora = alunoRepository.save(AlunoModel.builder()
				.nome("Isadora")
				.cpf("12345678911")
				.email("isadora@email.com")
				.sobrenome("Brito").build());

		TurmaModel turma = turmaRepository.save(TurmaModel.builder()
			.id(new IdTurma("POO", 2023, 2))
			.nome("Programação Orientada a Objetos")
			.vagas_minimas(1)
			.vagas_maximas(20)
			.build()
		);

		matriculaRepository.save(MatriculaModel.builder()
			.aluno(isadora)
			.turma(turma)
			.build()
		);

		matriculaRepository.save(MatriculaModel.builder()
				.aluno(victor)
				.turma(turma)
				.build());

	}

}
