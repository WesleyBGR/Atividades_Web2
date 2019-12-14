package br.ifpe.web2.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifpe.web2.model.Aluno;

public interface AlunoDAO extends JpaRepository<Aluno, Integer> {

}
