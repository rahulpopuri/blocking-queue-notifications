package notifications;

import com.bubblewrap.notifications.NotificationManager;
import com.bubblewrap.notifications.alert.Alert;
import com.bubblewrap.notifications.alert.AlertFactory;
import com.bubblewrap.notifications.alert.AlertType;
import com.bubblewrap.notifications.message.Message;
import com.bubblewrap.notifications.message.MessageFactory;
import com.bubblewrap.notifications.message.MessageType;

public class EmailTester {

	public static void main(String [] args){
		
		Alert a = AlertFactory.getAlert("test email", AlertType.ADMIN);
		Message m = MessageFactory.getMessage(MessageType.EMAIL, "bubblewrapstudios@gmail.com", a);
		
		NotificationManager.getInstance().addMessage(m);
	}
}
