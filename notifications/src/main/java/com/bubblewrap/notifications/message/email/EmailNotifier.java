package com.bubblewrap.notifications.message.email;

import java.util.concurrent.BlockingQueue;

import com.bubblewrap.notifications.Notifier;
import com.bubblewrap.notifications.message.Message;
import com.bubblewrap.notifications.message.MessageType;
import com.bubblewrap.notifications.utils.EmailUtils;

public class EmailNotifier extends Notifier {

	public EmailNotifier(BlockingQueue<Message> queue) {
		super(MessageType.EMAIL, queue);
	}

	@Override
	protected void process(Message m) {
		EmailUtils email = EmailUtils.getInstance();
		EmailMessage message = (EmailMessage) m;
		email.sendEmail(message.getSubject(), m.getData().toString(), m.getRecipient().toString());

	}

}
