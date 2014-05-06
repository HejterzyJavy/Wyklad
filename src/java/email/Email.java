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
private static final String FROM = "autorentwypozyczalnia@gmail.com";
// Hasło do konta osoby która wysyła maila
private static final String PASSWORD = "samochodrent";
// Adres email osoby do której wysyłany jest mail
private  String TO = "";
// Temat wiadomości
private String SUBJECT = "INFORMACJA O AKCEPTACJI WNIOSKU";
// Treść wiadomości
private String CONTENT = "Zamieszczona umowe nalezy wydrukowac i podpisac.";
// Ścieżka do pliku
private static final String PATH_FILE = "c:/Users/Adrian/projektISZ/Wyklad/umowa.pdf";
 
public  void wyslijAkceptacja(String decyzja,String emailOdbiorcy) {
try {
    String gdzieWyslac=emailOdbiorcy;
   // TO=emailOdbiorcy;
    
new Email().sendAccept(gdzieWyslac);
System.out.println("Wiadomość wysłana");
} catch (MessagingException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
}
 


void sendAccept(String gdzieWyslac) throws MessagingException {
 
this.TO=gdzieWyslac;    
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

public  void wyslijOdrzucenie(String decyzja,String emailOdbiorcy,String marka,String model) {
try {
    String gdzieWyslac=emailOdbiorcy;
    String opis=decyzja;
    String markas=marka;
    String models=model;
    
new Email().sendDontAccept(gdzieWyslac,opis,markas,models);
System.out.println("Wiadomość wysłana");
} catch (MessagingException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
}


void sendDontAccept(String gdzieWyslac,String opis,String marka, String model) throws MessagingException {
 
  this.SUBJECT="INFORAMCJA O ODRZUCENIU WNIOSKU";  
  this.TO=gdzieWyslac;  
  this.CONTENT="Niestety nie mozemy zraealizowac pana zlecenia na wypozyczenie "+marka+" "+model+" poniewaz "+opis;
  Properties props = new Properties();
  props.put("mail.transport.protocol", "smtps");
  props.put("mail.smtps.auth", "true");

  // Inicjalizacja sesji
  Session mailSession = Session.getDefaultInstance(props);

  // ustawienie debagowania, jeśli nie chcesz oglądać logów to usuń
  // linijkę poniżej lub zmień wartość na false
  mailSession.setDebug(true);

  // Tworzenie wiadomości email
  MimeMessage message = new MimeMessage(mailSession);
  message.setSubject(SUBJECT);
  message.setContent(CONTENT, "text/plain; charset=ISO-8859-2");
  message.addRecipient(Message.RecipientType.TO, new InternetAddress(TO));

  Transport transport = mailSession.getTransport();
  transport.connect(HOST, PORT, FROM, PASSWORD);

  // wysłanie wiadomości
  transport.sendMessage(message, message
    .getRecipients(Message.RecipientType.TO));
  transport.close();
 }
 
 
 
 


}