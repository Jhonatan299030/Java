package br.com.lorde.supremo.loja.controller;

import br.com.lorde.supremo.loja.controller.dto.CompraDto;
import br.com.lorde.supremo.loja.model.Compra;
import br.com.lorde.supremo.loja.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/compra")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @PostMapping
    public Compra realizaCompra(@RequestBody CompraDto compra){
        return compraService.realizaCompra(compra);
    }

}
