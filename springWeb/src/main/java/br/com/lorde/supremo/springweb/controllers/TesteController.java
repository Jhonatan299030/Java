package br.com.lorde.supremo.springweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TesteController {

    @GetMapping("teste/teste")
    public String chamarindex(){
        return "pipoca";
    }
}
