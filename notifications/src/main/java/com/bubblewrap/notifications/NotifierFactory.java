package com.bubblewrap.notifications;

import java.util.concurrent.BlockingQueue;

import com.bubblewrap.notifications.message.Message;
import com.bubblewrap.notifications.message.MessageType;
import com.bubblewrap.notifications.message.email.EmailNotifier;

public class NotifierFactory {

	public static Notifier getNotifier(MessageType type, BlockingQueue<Message> queue) {
		switch (type) {
		case EMAIL:
			return new EmailNotifier(queue);
		case PUSH:
			return new PushNotifier(queue);
		default:
			throw new IllegalArgumentException("Unsupported notification type: " + type);
		}
	}
}
