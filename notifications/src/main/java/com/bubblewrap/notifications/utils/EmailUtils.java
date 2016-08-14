package com.bubblewrap.notifications.utils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EmailUtils {

	private static EmailUtils email = null;

	private static Logger log = LogManager.getLogger();

	private EmailUtils() {
	}

	public static EmailUtils getInstance() {
		if (email == null) {
			email = new EmailUtils();
		}
		return email;
	}

	/**
	 * Sends an email to the specified user
	 * 
	 * @param subject
	 * @param body
	 * @param to
	 */
	public void sendEmail(String subject, String body, String to) {

		Properties props = new Properties();
		props.put("mail.smtp.host", getEmailProperty("mail.smtp.host"));
		props.put("mail.smtp.socketFactory.port", getEmailProperty("mail.smtp.socketFactory.port"));
		props.put("mail.smtp.socketFactory.class", getEmailProperty("mail.smtp.socketFactory.class"));
		props.put("mail.smtp.auth", getEmailProperty("mail.smtp.auth"));
		props.put("mail.smtp.port", getEmailProperty("mail.smtp.port"));

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(getEmailProperty("email.user"), getEmailProperty("email.password"));
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(getEmailProperty("email.from")));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject(subject);
			message.setText(body);

			Transport.send(message);

			log.info("Sent email to " + to);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	private String getEmailProperty(String propName) {
		return (String) PropertyFileUtils.getInstance().getProperty(propName);
	}
}
