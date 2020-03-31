package br.com.lorde.supremo.jms.produtors;

import br.com.lorde.supremo.jms.InitConnection;
import br.com.lorde.supremo.jms.modelo.Pedido;
import br.com.lorde.supremo.jms.modelo.PedidoFactory;

import javax.jms.Message;
import javax.jms.MessageProducer;

public class TesteProdutorTopicoObject {

    public static void main(String[] args) throws Exception{
        InitConnection initConnection = new InitConnection("loja");
        MessageProducer producer = initConnection.getSession().createProducer(initConnection.getDestination());

        Pedido pedido = new PedidoFactory().geraPedidoComValores();

        Message message = initConnection.getSession().createObjectMessage(pedido);
        producer.send(message);

        initConnection.closeConnection();
    }
}
