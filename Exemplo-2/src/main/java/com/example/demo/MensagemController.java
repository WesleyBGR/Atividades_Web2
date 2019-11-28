package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.model.Mensagem;

@Controller
public class MensagemController {

	@GetMapping("/exibirForm")
	public String ExibirForm(Mensagem mensagem) {
		return "form-mensagem";
	}
	
	@PostMapping("/salvarMensagem")
	public String SalvarMensagem(Mensagem mensagem) {
		System.out.println(mensagem);
		return "form-mensagem";
	}
}
