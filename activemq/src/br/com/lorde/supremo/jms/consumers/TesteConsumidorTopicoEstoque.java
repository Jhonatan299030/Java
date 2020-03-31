package br.com.lorde.supremo.jms.consumers;

import br.com.lorde.supremo.jms.ConsumerListner;
import br.com.lorde.supremo.jms.InitConnection;

import javax.jms.MessageConsumer;
import javax.jms.Topic;

public class TesteConsumidorTopicoEstoque {

    public static void main(String[] args) throws Exception{
        InitConnection initConnection = new InitConnection("loja", "estoque");

        MessageConsumer consumer = initConnection.getSession().createDurableSubscriber(
            (Topic) initConnection.getDestination(), "signature_estoque"
        );

        ConsumerListner consumerListner = new ConsumerListner();
        consumerListner.getConsumerListnerMsgText(consumer);

        initConnection.closeConnection();
    }
}
