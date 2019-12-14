package br.ifpe.web2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpe.web2.model.Aluno;
import br.ifpe.web2.persistence.AlunoDAO;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoDAO alunoDAO;

	public List<Aluno> listarTodos() {
		return alunoDAO.findAll();
	}

	public Optional<Aluno> findById(Integer id) {
		return alunoDAO.findById(id);
	}

	public void delete(Aluno entity) {
		alunoDAO.delete(entity);
	}


}
