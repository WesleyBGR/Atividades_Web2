package br.ifpe.web2.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifpe.web2.acesso.Usuario;

public interface UsuarioDAO extends JpaRepository<Usuario, Integer> {
	
	public Usuario findByLoginAndSenha(String login, String senha);

}
