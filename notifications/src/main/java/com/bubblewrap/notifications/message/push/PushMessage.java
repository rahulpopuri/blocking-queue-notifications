package com.bubblewrap.notifications.message.push;

import com.bubblewrap.notifications.alert.Alert;
import com.bubblewrap.notifications.message.Message;
import com.bubblewrap.notifications.message.MessageType;

public class PushMessage extends Message {

	public PushMessage(String recipientGCMId, Alert data) {
		super(MessageType.PUSH, recipientGCMId, data);
	}

}
