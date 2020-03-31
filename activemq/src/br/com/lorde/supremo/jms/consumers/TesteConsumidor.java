package br.com.lorde.supremo.jms.consumers;

import br.com.lorde.supremo.jms.ConsumerListner;
import br.com.lorde.supremo.jms.InitConnection;

import javax.jms.MessageConsumer;

public class TesteConsumidor {

    public static void main(String[] args) throws Exception{
        InitConnection initConnection = new InitConnection("financeiro");
        MessageConsumer consumer = initConnection.getSession().createConsumer(initConnection.getDestination());

        ConsumerListner consumerListner = new ConsumerListner();
        consumerListner.getConsumerListnerMsgText(consumer);

        initConnection.closeConnection();
    }
}
