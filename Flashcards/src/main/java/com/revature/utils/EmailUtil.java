package com.revature.utils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtil {
	public static boolean sendEmail(String to, String body, String heading) {
		// Sender's email ID needs to be mentioned
		String from = "flashcardprojectemail";
		String password = "p4ssw0rd1";

		// Assuming you are sending email from localhost
		String host = "smtp.gmail.com";

		// Get system properties
		Properties props = System.getProperties();

		String emailPort = "587";// gmail's smtp port
		props = System.getProperties();
		props.put("mail.smtp.port", emailPort);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");

		// Setup mail server
		props.put("mail.smtp.host", host);

		// Get the default Session object
		Session session = Session.getDefaultInstance(props);

		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// Set Subject: header field
			message.setSubject(heading);

			// Now set the actual message
			message.setText(body);

			// Send message
			Transport transport = session.getTransport("smtp");
			transport.connect(host, from, password);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();

			return true;
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
		return false;
	}
}