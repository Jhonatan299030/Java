package br.com.lorde.supremo.springweb.controllers;

import br.com.lorde.supremo.springweb.models.Aluno;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/aluno")
public class AlunoController {

    @GetMapping("/cadastrar")
    public String cadastrar(Model model){
        model.addAttribute("aluno", new Aluno());
        return "/aluno/cadastrar";
    }

    @GetMapping("/aluno/listar")
    public String listar(Model model){
        List<Aluno> alunos = null;
        model.addAttribute("alunos", alunos);
        return "aluno/listar";
    }
}
