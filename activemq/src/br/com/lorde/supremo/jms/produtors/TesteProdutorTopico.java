package br.com.lorde.supremo.jms.produtors;

import br.com.lorde.supremo.jms.InitConnection;

import javax.jms.Message;
import javax.jms.MessageProducer;

public class TesteProdutorTopico {

    public static void main(String[] args) throws Exception{
        InitConnection initConnection = new InitConnection("loja");
        MessageProducer producer = initConnection.getSession().createProducer(initConnection.getDestination());

        for (int i = 1; i <= 2; i++) {
            Message message = initConnection.getSession().createTextMessage("Produzindo qualquer coisa nº " + i);
//            message.setBooleanProperty("filter", false); // Just for selector
            producer.send(message);
        }

        initConnection.closeConnection();
    }
}
