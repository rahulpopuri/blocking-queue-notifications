package com.bubblewrap.notifications.message;

public abstract class Message {
	protected MessageType type;
	private Object recipient;
	private Object data;

	public Message(MessageType type) {
		this.type = type;
	}

	public MessageType getType() {
		return type;
	}

	public void setType(MessageType type) {
		this.type = type;
	}

	public Object getRecipient() {
		return recipient;
	}

	public void setRecipient(Object recipient) {
		this.recipient = recipient;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Message [type=" + type + ", recipient=" + recipient + ", data=" + data + "]";
	}

}
