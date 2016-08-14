package com.bubblewrap.notifications.message.text;

import com.bubblewrap.notifications.message.Message;
import com.bubblewrap.notifications.message.MessageType;

public class TextMessage extends Message {
	
	public TextMessage(String number, String message) {
		super(MessageType.TEXT);
		this.setRecipient(number);
		this.setData(message);
	}

}
