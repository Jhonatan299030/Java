package br.com.lorde.supremo.springweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String pipoca(){
        return "pipoca";
    }
}
