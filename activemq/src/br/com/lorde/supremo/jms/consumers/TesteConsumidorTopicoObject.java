package br.com.lorde.supremo.jms.consumers;

import br.com.lorde.supremo.jms.ConsumerListner;
import br.com.lorde.supremo.jms.InitConnection;

import javax.jms.MessageConsumer;
import javax.jms.Topic;

public class TesteConsumidorTopicoObject {

    public static void main(String[] args) throws Exception{
        System.setProperty("org.apache.activemq.SERIALIZABLE_PACKAGES","*");
        InitConnection initConnection = new InitConnection("loja","producao");

        MessageConsumer consumer = initConnection.getSession().createDurableSubscriber(
            (Topic) initConnection.getDestination(), "signature_object"
        );

        ConsumerListner consumerListner = new ConsumerListner();
        consumerListner.getConsumerListnerMsgPedido(consumer);

        initConnection.closeConnection();
    }
}
