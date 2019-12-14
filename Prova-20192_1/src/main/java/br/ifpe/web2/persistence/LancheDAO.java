package br.ifpe.web2.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifpe.web2.model.Lanche;

public interface LancheDAO extends JpaRepository<Lanche, Integer> {

}
