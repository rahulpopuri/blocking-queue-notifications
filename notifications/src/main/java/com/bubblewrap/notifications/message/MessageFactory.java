package com.bubblewrap.notifications.message;

import com.bubblewrap.notifications.alert.Alert;
import com.bubblewrap.notifications.message.email.EmailMessage;
import com.bubblewrap.notifications.message.push.PushMessage;

public class MessageFactory {

	public static Message getMessage(MessageType type, String recipient, Alert data) {
		switch (type) {
		case EMAIL:
			return new EmailMessage(recipient, data);
		case PUSH:
			return new PushMessage(recipient, data);
		default:
			throw new IllegalArgumentException("Unsupported notification type: " + type);
		}
	}

}
