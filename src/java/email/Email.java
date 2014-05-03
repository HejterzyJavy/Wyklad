package email;

import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.FileDataSource;
import javax.activation.DataHandler;
 
import java.util.Properties;
 
/**
11.*
12.* 
13.*
14.*/
public class Email {
 
private static final String HOST = "smtp.gmail.com";
private static final int PORT = 465;
// Adres email osby która wysyła maila
private static final String FROM = "adrianwojton91@gmail.com";
// Hasło do konta osoby która wysyła maila
private static final String PASSWORD = "";
// Adres email osoby do której wysyłany jest mail
private static final String TO = "gardian92@o2.pl";
// Temat wiadomości
private static final String SUBJECT = "Umowa wynajmu samochodu";
// Treść wiadomości
private static final String CONTENT = "Zamieszczona umowe nalezy wydrukowac i podpisac.";
// Ścieżka do pliku
private static final String PATH_FILE = "c:/Users/Adrian/projektISZ/Wyklad/umowa.pdf";
 
public  void wyslijEmail() {
try {
new Email().send();
System.out.println("Wiadomość wysłana");
} catch (MessagingException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
}
 
void send() throws MessagingException {
 
Properties props = new Properties();
props.put("mail.transport.protocol", "smtps");
props.put("mail.smtps.auth", "true");
 
// Pobranie sesji
Session mailSession = Session.getDefaultInstance(props, null);
 
// Tworzenie wiadomości
MimeMessage message = new MimeMessage(mailSession);
message.setSubject(SUBJECT);
 
// Stworzenie części wiadomosci z treścią
MimeBodyPart textPart = new MimeBodyPart();
textPart.setContent(CONTENT, "text/html; charset=ISO-8859-2");
 
// Stworzenie części z załacznikami
MimeBodyPart attachFilePart = new MimeBodyPart();
FileDataSource fds = new FileDataSource(PATH_FILE);
attachFilePart.setDataHandler(new DataHandler(fds));
attachFilePart.setFileName(fds.getName());
 
// Zestawienie obydwu części maila w jedną wieloczęściową
Multipart mp = new MimeMultipart();
mp.addBodyPart(textPart);
mp.addBodyPart(attachFilePart);
 
// Dodanie treści maila
message.setContent(mp);
message.addRecipient(Message.RecipientType.TO, new InternetAddress(TO));
 
Transport transport = mailSession.getTransport();
transport.connect(HOST, PORT, FROM, PASSWORD);
 
// Wysąłnei maila
transport.sendMessage(message, message
.getRecipients(Message.RecipientType.TO));
transport.close();
}
}