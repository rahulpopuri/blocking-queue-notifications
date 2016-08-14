package com.bubblewrap.notifications.message.push;

import com.bubblewrap.notifications.message.Message;
import com.bubblewrap.notifications.message.MessageType;

public class PushMessage extends Message {

	public PushMessage(String recipientGCMId, Object data) {
		super(MessageType.PUSH);
		this.setRecipient(recipientGCMId);
		this.setData(data);
	}

}
