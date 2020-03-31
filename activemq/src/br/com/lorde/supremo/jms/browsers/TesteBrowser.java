package br.com.lorde.supremo.jms.browsers;

import br.com.lorde.supremo.jms.InitConnection;

import javax.jms.*;
import java.util.Enumeration;

public class TesteBrowser {

    public static void main(String[] args) throws Exception{
        InitConnection initConnection = new InitConnection("financeiro");
        QueueBrowser browser = initConnection.getSession().createBrowser((Queue) initConnection.getDestination());

        Enumeration msgs = browser.getEnumeration();
        while (msgs.hasMoreElements()) {
            TextMessage msg = (TextMessage) msgs.nextElement();
            System.out.println("Message: " + msg.getText());
        }

        initConnection.closeConnection();
    }
}
