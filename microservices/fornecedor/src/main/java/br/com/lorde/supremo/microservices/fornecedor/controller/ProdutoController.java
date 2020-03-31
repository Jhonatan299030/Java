package br.com.lorde.supremo.microservices.fornecedor.controller;

import br.com.lorde.supremo.microservices.fornecedor.model.Produto;
import br.com.lorde.supremo.microservices.fornecedor.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@RequestMapping("/{estado}")
	public List<Produto> getProdutosPorEstado(@PathVariable("estado") String estado) {
		return produtoService.getProdutosPorEstado(estado);
	}
}
