package br.ifpe.web2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpe.web2.model.Lanche;
import br.ifpe.web2.persistence.LancheDAO;

@Service
public class LancheService {
	
	@Autowired
	private LancheDAO lancheDAO;
	
	public List<Lanche> listarTodosLanches(){
		return lancheDAO.findAll();
	}
}
