package com.tcc.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcc.app.model.PessoaJuridica;
import com.tcc.app.service.PessoaJuridicaService;

@RestController
@RequestMapping(value = "pessoajuridica")
public class PessoaJuridicaController {
	
	@Autowired
	private PessoaJuridicaService pessoaJuridicaService;
	
	  @PostMapping
	    public ResponseEntity<PessoaJuridica> criarUsuario(@RequestBody PessoaJuridica pessoaJuridica) {
	        PessoaJuridica usuarioCriado = pessoaJuridicaService.criarUsuario(pessoaJuridica);
	        return new ResponseEntity<>(usuarioCriado, HttpStatus.CREATED);
	    }
	

}
