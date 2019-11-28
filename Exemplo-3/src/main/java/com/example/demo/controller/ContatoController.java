package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Contato;

@Controller
public class ContatoController {
	
	private List<Contato> contatos = new ArrayList<>();
	
	@GetMapping("/exibirContato")
	public String exibirForm(Contato contato) {
		return "contatos-form";
	}
	
	@PostMapping("salvarContato")
	public String salvarContato(Contato contato) {
		this.contatos.add(contato);
		System.out.println(contato);
		return "redirect:/exibirContato";
	}
}
