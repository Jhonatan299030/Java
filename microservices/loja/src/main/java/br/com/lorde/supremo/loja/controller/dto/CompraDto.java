package br.com.lorde.supremo.loja.controller.dto;

import java.util.List;

public class CompraDto {
    private List<ItensCompraDto> itens;
    private EnderecoDto endereco;

    public List<ItensCompraDto> getItens() {
        return itens;
    }

    public void setItens(List<ItensCompraDto> itens) {
        this.itens = itens;
    }

    public EnderecoDto getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDto endereco) {
        this.endereco = endereco;
    }
}
