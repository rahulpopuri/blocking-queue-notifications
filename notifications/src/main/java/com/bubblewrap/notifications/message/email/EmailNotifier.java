package com.bubblewrap.notifications.message.email;

import java.util.concurrent.BlockingQueue;

import com.bubblewrap.notifications.Notifier;
import com.bubblewrap.notifications.alert.Alert;
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
		switch (m.getAlert().getType()) {
		case ADMIN:
			email.sendAdminEmail(m.getAlert().getData().toString(), EmailType.ADMIN);
			break;
		default:
			break;
		}
	}

}
