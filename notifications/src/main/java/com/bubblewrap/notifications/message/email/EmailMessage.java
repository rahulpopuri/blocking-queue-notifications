package com.bubblewrap.notifications.message.email;

import com.bubblewrap.notifications.alert.Alert;
import com.bubblewrap.notifications.message.Message;
import com.bubblewrap.notifications.message.MessageType;

public class EmailMessage extends Message {

	// TODO Validate email address
	public EmailMessage(Object address, Alert data) {
		super(MessageType.EMAIL, (String) address, data);
	}

}
