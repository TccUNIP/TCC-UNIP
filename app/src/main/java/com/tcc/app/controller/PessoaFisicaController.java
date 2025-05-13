package com.tcc.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcc.app.model.PessoaFisica;
import com.tcc.app.service.PessoaFisicaService;

@RestController
@RequestMapping(value = "pessoafisica")
public class PessoaFisicaController {
	
	@Autowired
	private PessoaFisicaService pessoaFisicaService;
	
	  @PostMapping
	    public ResponseEntity<PessoaFisica> criarUsuario(@RequestBody PessoaFisica pessoaFisica) {
	        PessoaFisica usuarioCriado = pessoaFisicaService.criarUsuario(pessoaFisica);
	        return new ResponseEntity<>(usuarioCriado, HttpStatus.CREATED);
	    }
	
	

}
