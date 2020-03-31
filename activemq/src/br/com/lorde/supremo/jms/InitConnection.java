package br.com.lorde.supremo.jms;

import javax.jms.*;
import javax.naming.InitialContext;
import java.util.*;

public class InitConnection {
    private InitialContext context;
    private ConnectionFactory factory;
    private Connection connection;
    private Destination destination;
    private Session session;

    public Properties getProperties(Map<String,String> propertiesMap){
        Properties properties = new Properties();

        for(Map.Entry map : propertiesMap.entrySet()){
            properties.setProperty((String) map.getKey(), (String) map.getValue());
        }

        return properties;
    }

    public Properties getDefaultProperties(){
        Map<String, String> properties = new HashMap<>();

        properties.put("java.naming.factory.initial", "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        properties.put("java.naming.provider.url", "tcp://localhost:61616");
        properties.put("queue.financeiro", "fila.financeiro");
        properties.put("topic.loja", "topico.loja");

        return getProperties(properties);
    }

    public void closeConnection() throws Exception {
        this.connection.close();
        this.session.close();
        this.context.close();
    }

    public InitConnection(String destination) {
        try {
            this.context = new InitialContext(getDefaultProperties());
            this.factory = (ConnectionFactory) this.context.lookup("ConnectionFactory");
            this.connection = this.factory.createConnection();
            this.session = this.connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            this.destination = (Destination) this.context.lookup(destination);

            connection.start();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    public InitConnection(String destination, String connectionID){
        try {
            this.context = new InitialContext(getDefaultProperties());
            this.factory = (ConnectionFactory) this.context.lookup("ConnectionFactory");
            this.connection = this.factory.createConnection();
            this.connection.setClientID(connectionID);
            this.session = this.connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            this.destination = (Destination) this.context.lookup(destination);

            connection.start();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public InitialContext getContext() {
        return context;
    }

    public void setContext(InitialContext context) {
        this.context = context;
    }

    public ConnectionFactory getFactory() {
        return factory;
    }

    public void setFactory(ConnectionFactory factory) {
        this.factory = factory;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
