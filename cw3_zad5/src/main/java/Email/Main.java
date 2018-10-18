package Email;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class Main {
    public static void main(String[] argv) {
        EmailMessage wiadomosc = EmailMessage.builder()
                .addFrom("kuba.ficon23@gmail.com")
                .addTo("kuba.ficon23@gmail.com")
                .addSubject("Mail testowy")
                .addContent("Brak tresci")
                .build();

        String host = "localhost";
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        Session session = Session.getDefaultInstance(properties);

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(wiadomosc.getFrom()));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(wiadomosc.getTo().get(0)));
            message.setSubject(wiadomosc.getSubject());
            message.setText(wiadomosc.getContent());
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }
}
