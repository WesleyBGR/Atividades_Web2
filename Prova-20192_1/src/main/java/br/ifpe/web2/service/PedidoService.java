package br.ifpe.web2.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpe.web2.model.Aluno;
import br.ifpe.web2.model.Lanche;
import br.ifpe.web2.model.Pedido;
import br.ifpe.web2.persistence.AlunoDAO;
import br.ifpe.web2.persistence.LancheDAO;
import br.ifpe.web2.persistence.PedidoDAO;

@Service
public class PedidoService {
	
	@Autowired
	private AlunoDAO alunoDAO;

	@Autowired
	private LancheDAO lancheDAO;

	@Autowired
	private PedidoDAO pedidoDAO;
	
	public List<Pedido> listarTodosPedidos () {
		return pedidoDAO.findAll();
	}
	
	public void registrarPagamento(Integer id) {
		
		Pedido pedido = this.pedidoDAO.getOne(id);	
		pedido.getAluno().setDivida(0);
		pedido.setDataPagamento(new Date());
		this.pedidoDAO.save(pedido);
		
	
	}
	
	
	public void registrarPedido(Pedido pedido) {
		
		if (pedido.getQuantidade() <= pedido.getLanche().getQuantidadeDisponivel() && pedido.getAluno().getDivida() <= 0 ) {
			pedido.setDataPagamento(pedido.getDataPedido());
			Lanche lanche = pedido.getLanche();
			Aluno aluno = pedido.getAluno();
			aluno.setDivida((lanche.getValor()*pedido.getQuantidade()));
			lanche.setQuantidadeDisponivel(pedido.getLanche().getQuantidadeDisponivel()
					- pedido.getQuantidade());
			pedido.setDataPedido(new Date());
			this.lancheDAO.save(lanche);
			this.pedidoDAO.save(pedido);
			this.alunoDAO.save(aluno);
		}
	}
	
}
