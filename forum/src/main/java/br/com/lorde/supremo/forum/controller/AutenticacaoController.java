package br.com.lorde.supremo.forum.controller;

import br.com.lorde.supremo.forum.controller.dto.TokenDto;
import br.com.lorde.supremo.forum.form.LoginForm;
import br.com.lorde.supremo.forum.config.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticar(@RequestBody @Valid LoginForm form){
        try{
            Authentication auth = authenticationManager.authenticate(form.converter());
            String token = tokenService.generete(auth);
            return ResponseEntity.ok(new TokenDto(token, "Bearer"));
        }catch (AuthenticationException e){
            return ResponseEntity.badRequest().build();
        }
    }
}
