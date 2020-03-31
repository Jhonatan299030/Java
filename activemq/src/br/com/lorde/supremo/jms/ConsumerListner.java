package br.com.lorde.supremo.jms;

import br.com.lorde.supremo.jms.modelo.Pedido;

import javax.jms.*;
import java.io.Serializable;
import java.util.Scanner;

public class ConsumerListner {

    public void getConsumerListnerMsgText(MessageConsumer consumer) throws JMSException {
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                try {
                    TextMessage text = (TextMessage) message;
                    System.out.println("Recebida a mensagem: " + text.getText());
                }
                catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });

        System.out.println("Consumer ativo!");
        new Scanner(System.in).nextLine();
    }

    public void getConsumerListnerMsgPedido(MessageConsumer consumer) throws JMSException {
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                try {
                    ObjectMessage objectMessage = (ObjectMessage) message;
                    Serializable object = objectMessage.getObject();
                    Pedido pedido = (Pedido) object;
                    System.out.println(pedido.getCodigo());
                }
                catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });

        System.out.println("Consumer ativo!");
        new Scanner(System.in).nextLine();
    }
}
