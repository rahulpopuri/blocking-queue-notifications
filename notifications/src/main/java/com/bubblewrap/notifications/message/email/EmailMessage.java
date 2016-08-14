package com.bubblewrap.notifications.message.email;

import com.bubblewrap.notifications.message.Message;
import com.bubblewrap.notifications.message.MessageType;

public class EmailMessage extends Message {

	private String subject;

	// TODO Validate email address
	public EmailMessage(String subject, String emailAddress, Object data) {
		super(MessageType.EMAIL);
		this.setSubject(subject);
		this.setRecipient(emailAddress);
		this.setData(data);
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "EmailMessage [subject=" + subject + ", type=" + type + "]";
	}

}
