package com.tcc.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tcc.app.service.PessoaFisicaService;
import com.tcc.app.service.PessoaJuridicaService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private PessoaFisicaService pessoaFisicaService;

    @Autowired
    private PessoaJuridicaService pessoaJuridicaService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password, @RequestParam String tipoUsuario) {
        String token;
        if ("fisica".equalsIgnoreCase(tipoUsuario)) {
            token = pessoaFisicaService.login(email, password);
        } else if ("juridica".equalsIgnoreCase(tipoUsuario)) {
            token = pessoaJuridicaService.login(email, password);
        } else {
            throw new RuntimeException("Tipo de usuário inválido!");
        }
        return ResponseEntity.ok(token);
    }
}