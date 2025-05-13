package com.tcc.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcc.app.model.PessoaJuridica;
import com.tcc.app.repository.PessoaJuridicaRepository;

@Service
public class PessoaJuridicaService {

	@Autowired
	private PessoaJuridicaRepository pessoaJuridicaRepository;

	@Autowired
	private JwtService jwtService;

	public PessoaJuridica criarUsuario(PessoaJuridica pessoaJuridica) {
		return pessoaJuridicaRepository.save(pessoaJuridica);
	}

	public String login(String email, String password) {
		PessoaJuridica usuario = pessoaJuridicaRepository.findByEmail(email)
				.orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
		if (!usuario.getPassword().equals(password)) {
			throw new RuntimeException("Senha inválida");
		}
		return jwtService.gerarToken(usuario);
	}

}
