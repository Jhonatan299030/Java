package br.com.lorde.supremo.loja.model;

public class Compra {

    private Long pedidoId;

    private int tempoPreparo;

    private String enderecoDestino;

    public Compra(Long pedidoId, int tempoPreparo, String enderecoDestino) {
        this.pedidoId = pedidoId;
        this.tempoPreparo = tempoPreparo;
        this.enderecoDestino = enderecoDestino;
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public int getTempoPreparo() {
        return tempoPreparo;
    }

    public void setTempoPreparo(int tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }

    public String getEnderecoDestino() {
        return enderecoDestino;
    }

    public void setEnderecoDestino(String enderecoDestino) {
        this.enderecoDestino = enderecoDestino;
    }
}
