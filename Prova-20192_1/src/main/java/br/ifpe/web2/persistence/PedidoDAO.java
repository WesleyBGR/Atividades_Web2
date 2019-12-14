package br.ifpe.web2.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifpe.web2.model.Pedido;

public interface PedidoDAO extends JpaRepository<Pedido, Integer> {

}
