package br.com.lorde.supremo.enviaemail;

import org.apache.commons.mail.*;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    public void enviar(String nome, String emailDestinatario){
        try {
            Email email = new SimpleEmail();
            email.setHostName("smtp.gmail.com");
//            email.setHostName("smtp.live.com");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator("lorde.supremo.299030@gmail.com", "LordeSupremo31527896"));
            email.setSSLOnConnect(true);

            email.setFrom("lorde.supremo.299030@gmail.com");
            email.setSubject("Você foi convidado pelo Lorde Supremo");
            email.setMsg("Olá " + nome + ". Você acaba de ser convidado pelo Lorde Supremo para comparecer ao treinamento de IA que ocorrerá neste sábado.");
            email.addTo(emailDestinatario);
            email.send();
            System.out.println(email.getSentDate());

        } catch (EmailException e) {
            e.printStackTrace();
        }
    }
}
