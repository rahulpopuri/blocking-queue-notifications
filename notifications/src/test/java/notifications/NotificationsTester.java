package notifications;

import com.bubblewrap.notifications.NotificationManager;
import com.bubblewrap.notifications.message.Message;
import com.bubblewrap.notifications.message.email.EmailMessage;
import com.bubblewrap.notifications.message.text.TextMessage;

public class NotificationsTester {

	public static void main(String[] args) {

		Message email = new EmailMessage("Test subject", "test_email@domain.com", "Test content");

		Message text = new TextMessage("123456789", "Test text message");

		NotificationManager.getInstance().addMessage(email);
		NotificationManager.getInstance().addMessage(text);

		try {
			NotificationManager.getInstance().stop();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
