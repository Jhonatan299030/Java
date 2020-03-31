package br.com.lorde.supremo.jms.produtors;

import br.com.lorde.supremo.jms.InitConnection;
import br.com.lorde.supremo.jms.modelo.Pedido;
import br.com.lorde.supremo.jms.modelo.PedidoFactory;

import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.xml.bind.JAXB;
import java.io.StringWriter;

public class TesteProdutorTopicoXml {

    public static void main(String[] args) throws Exception{
        InitConnection initConnection = new InitConnection("loja");
        MessageProducer producer = initConnection.getSession().createProducer(initConnection.getDestination());

        Pedido pedido = new PedidoFactory().geraPedidoComValores();
        StringWriter writer = new StringWriter();
        JAXB.marshal(pedido, writer);

        Message message = initConnection.getSession().createTextMessage(writer.toString());
        producer.send(message);

        initConnection.closeConnection();
    }
}
