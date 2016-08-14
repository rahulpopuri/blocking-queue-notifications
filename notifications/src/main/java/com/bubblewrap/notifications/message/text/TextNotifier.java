package com.bubblewrap.notifications.message.text;

import java.util.concurrent.BlockingQueue;

import com.bubblewrap.notifications.Notifier;
import com.bubblewrap.notifications.message.Message;
import com.bubblewrap.notifications.message.MessageType;
import com.bubblewrap.notifications.utils.EmailUtils;
import com.bubblewrap.notifications.utils.PropertyFileUtils;

public class TextNotifier extends Notifier {

	public TextNotifier(BlockingQueue<Message> queue) {
		super(MessageType.TEXT, queue);
	}

	@Override
	protected void process(Message m) {
		TextMessage message = (TextMessage) m;
		EmailUtils utils = EmailUtils.getInstance();
		String emailAddress = message.getRecipient() + "@"
				+ (String) PropertyFileUtils.getInstance().getProperty("email.server");
		utils.sendEmail("", message.getData().toString(), emailAddress);

	}

}
