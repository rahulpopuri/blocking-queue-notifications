package com.bubblewrap.notifications;

import java.util.concurrent.BlockingQueue;

import com.bubblewrap.notifications.message.Message;
import com.bubblewrap.notifications.message.MessageType;

public class PushNotifier extends Notifier {

	public PushNotifier(BlockingQueue<Message> queue) {
		super(MessageType.PUSH, queue);
	}

	@Override
	protected void process(Message m) {
		switch (m.getAlert().getType()) {
		// TODO
		default:
			break;
		}

	}

}
