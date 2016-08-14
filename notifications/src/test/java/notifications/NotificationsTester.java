package notifications;

import com.bubblewrap.notifications.NotificationManager;
import com.bubblewrap.notifications.message.Message;
import com.bubblewrap.notifications.message.email.EmailMessage;
import com.bubblewrap.notifications.message.text.TextMessage;

public class NotificationsTester {

	public static void main(String[] args) throws InterruptedException {

		Message email = new EmailMessage("Test subject", "bubblewrapstudios@gmail.com", "Test body");

		Message text = new TextMessage("6479688051", "Test text message");

		NotificationManager.getInstance().addMessage(email);
		NotificationManager.getInstance().addMessage(text);

		Thread.sleep(5000);
		try {
			NotificationManager.getInstance().stop();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
