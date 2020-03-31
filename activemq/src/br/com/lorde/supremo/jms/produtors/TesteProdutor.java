package br.com.lorde.supremo.jms.produtors;

import br.com.lorde.supremo.jms.InitConnection;

import javax.jms.Message;
import javax.jms.MessageProducer;

public class TesteProdutor {

    public static void main(String[] args) throws Exception{
        InitConnection initConnection = new InitConnection("financeiro");
        MessageProducer producer = initConnection.getSession().createProducer(initConnection.getDestination());

        for (int i = 1; i <= 10; i++) {
            Message message = initConnection.getSession().createTextMessage("Avoa Bruxao nº " + i);
            producer.send(message);
        }

        initConnection.closeConnection();
    }
}
