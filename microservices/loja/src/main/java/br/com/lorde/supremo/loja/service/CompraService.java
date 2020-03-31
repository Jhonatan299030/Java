package br.com.lorde.supremo.loja.service;

import br.com.lorde.supremo.loja.connection.FornecedorClient;
import br.com.lorde.supremo.loja.controller.dto.*;
import br.com.lorde.supremo.loja.model.Compra;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraService {
//    @Value("${url.api.fornecedor}")
//    private String apiUrl;
//
//    @Autowired
//    private RestService restService;

    private static final Logger LOG = LoggerFactory.getLogger(CompraService.class);

    @Autowired
    private FornecedorClient fornecedorClient;

    public Compra realizaCompra(CompraDto compra) {
//        restService.getRequestObject(apiUrl + compra.getEndereco().getEstado(), InfoFornecedorDto.class);

        LOG.info("Buscando informações do fornecedor de {}", compra.getEndereco().getEstado());
        InfoFornecedorDto infoFornecedor = fornecedorClient.getInfoByEstado(compra.getEndereco().getEstado());

        LOG.info("Realizando um pedido.");
        InfoPedidoDto pedido = fornecedorClient.realizaPedido(compra.getItens());

        Compra objCompra = new Compra(pedido.getId(), pedido.getTempoPreparo(), compra.getEndereco().toString());

        return objCompra;
    }
}
