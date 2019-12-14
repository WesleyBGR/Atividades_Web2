package br.ifpe.web2.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ifpe.web2.model.Pedido;
import br.ifpe.web2.service.AlunoService;
import br.ifpe.web2.service.LancheService;
import br.ifpe.web2.service.PedidoService;

@Controller
public class PedidoController {

	@Autowired
	private AlunoService alunoService;
	

	@Autowired
	private LancheService lancheService;

	
	@Autowired
	private PedidoService pedidoService;


	@RequestMapping("/home")
	public String exibirPedido(Pedido pedido, Model model) {
		model.addAttribute("listaAlunos", this.alunoService.listarTodos());
		model.addAttribute("listaLanches", this.lancheService.listarTodosLanches());
		model.addAttribute("listaPedidos", this.pedidoService.listarTodosPedidos());
		return "pedido";
	}

	@PostMapping("/registrarPedido")
	public String registrarPedido(@Valid Pedido pedido, BindingResult br, Model model) {
		if (br.hasErrors()) {
			return exibirPedido(pedido, model);
		}
		this.pedidoService.registrarPedido(pedido);
		return "redirect:/home";

	}
	

	@GetMapping("/pagar")
	public String registrarPagamento(Integer id, Model model) {
		this.pedidoService.registrarPagamento(id);
		//Pedido pedido = this.pedidoDAO.getOne(id);
		//pedido.setDataPagamento(new Date());
		//this.pedidoDAO.save(pedido);
		return "redirect:/";
	}
}
