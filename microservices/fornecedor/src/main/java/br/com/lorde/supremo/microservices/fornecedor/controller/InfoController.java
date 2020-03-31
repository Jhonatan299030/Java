package br.com.lorde.supremo.microservices.fornecedor.controller;

import br.com.lorde.supremo.microservices.fornecedor.model.InfoFornecedor;
import br.com.lorde.supremo.microservices.fornecedor.service.InfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/info")
public class InfoController {

	private static final Logger LOG = LoggerFactory.getLogger(InfoController.class);
	
	@Autowired
	private InfoService infoService;
	
	@RequestMapping("/{estado}")
	public InfoFornecedor getInfoPorEstado(@PathVariable String estado) {
		LOG.info("recebido pedido de informações do fornecedor de {}", estado);
		return infoService.getInfoPorEstado(estado);
	}
}
