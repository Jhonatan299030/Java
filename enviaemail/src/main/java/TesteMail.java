import br.com.lorde.supremo.enviaemail.EmailService;

public class TesteMail {

    public static void main(String[] args) {
        new EmailService().enviar("Your Name", "your@email.com");
    }
}
