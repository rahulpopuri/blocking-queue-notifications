package com.bubblewrap.notifications.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
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

import com.bubblewrap.notifications.message.email.EmailType;


public class EmailUtils {

	private static EmailUtils email = null;
	private static Properties properties;
	
	private static Logger log = LogManager.getLogger();
	
	private EmailUtils () {
	}
	
	public static EmailUtils getInstance(){
		if(email == null) {
			email = new EmailUtils();
			loadProperties();
		}
		return email;
	}
	
	private static void loadProperties(){
		properties = new Properties();
	    try {
	    	InputStream in = EmailUtils.class.getClassLoader().getResourceAsStream("email.properties");
	        properties.load(in);
	        in.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } 
	}
	
	/**
	 * Sends an email to the default email address listed in Config.java
	 * @param body
	 * @param type
	 */
	public void sendAdminEmail(String body, EmailType type){
		sendEmail(body,type,"to_email");
	}

	/**
	 * Sends an email to the specified user
	 * @param body
	 * @param type
	 * @param to
	 */
	public void sendEmail(String body, EmailType type, String to){
		
		// GMAIL specific properties TODO: Move to email.properties
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		
		String subject = properties.getProperty(type.toString()+".subject");
		//String subject = "test";
		Session session = Session.getInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("user", "pwd");
				}
			});
		
		try {
			 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("from_email"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(to));
			message.setSubject(subject.replace("\"","") + " " + new Date().toString());
			message.setText(body);
 
			Transport.send(message);
 
			log.info("Sent " + type + " email to " + to);
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
