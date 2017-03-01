/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inse.draft.pkg1;


import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class Email {

    public void Email(String destination, String subject, String text, String from) {
        String host = "smtp.gmail.com";
        final String user = "bassistant0@gmail.com";
        final String password = "INSEGroup3B";

        String to = destination;

        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "587");


        Session session = Session.getDefaultInstance(properties,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject + "from: " + from);
            message.setText("Hi " + from + ", " + text);

            Transport.send(message);
            System.out.println("sent");
            
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}

