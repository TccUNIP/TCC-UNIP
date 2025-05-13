package com.tcc.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcc.app.model.PessoaFisica;
import com.tcc.app.repository.PessoaFisicaRepository;

@Service
public class PessoaFisicaService {

	@Autowired
	private PessoaFisicaRepository pessoaFisicaRepository;

	@Autowired
	private JwtService jwtService;

	public PessoaFisica criarUsuario(PessoaFisica pessoaFisica) {
		return pessoaFisicaRepository.save(pessoaFisica);
	}

	public String login(String email, String password) {
	    PessoaFisica usuario = pessoaFisicaRepository.findByEmail(email)
	            .orElseThrow(() -> new RuntimeException("Usuário com email " + email + " não foi encontrado!"));

	    if (!usuario.getPassword().equals(password)) {
	        throw new RuntimeException("Senha inválida para o email " + email);
	    }

	    return jwtService.gerarToken(usuario);
	}


}
