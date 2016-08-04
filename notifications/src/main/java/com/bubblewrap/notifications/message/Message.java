package com.bubblewrap.notifications.message;

import com.bubblewrap.notifications.alert.Alert;

public abstract class Message {
	protected MessageType type;
	private Object recipient;
	private Alert data;

	/**
	 * Creates a new message of the specified notification type
	 * 
	 * @param type
	 * @param recipient
	 * @param text
	 */
	public Message(MessageType type, Object recipient, Alert data) {
		this.type = type;
		this.recipient = recipient;
		this.data = data;
	}

	public Object getRecipient() {
		return recipient;
	}

	public void setRecipient(Object recipient) {
		this.recipient = recipient;
	}

	public Alert getAlert() {
		return data;
	}

	public void setAlert(Alert data) {
		this.data = data;
	}

	public MessageType getType() {
		return type;
	}

	public void setType(MessageType type) {
		this.type = type;
	}

}
