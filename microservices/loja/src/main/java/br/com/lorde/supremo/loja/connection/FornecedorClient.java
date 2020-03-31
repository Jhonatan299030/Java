package br.com.lorde.supremo.loja.connection;

import br.com.lorde.supremo.loja.controller.dto.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("fornecedor")
public interface FornecedorClient {

    @GetMapping("/info/{estado}")
    InfoFornecedorDto getInfoByEstado(@PathVariable String estado);

    @PostMapping("/pedido")
    InfoPedidoDto realizaPedido(List<ItensCompraDto> itens);
}
