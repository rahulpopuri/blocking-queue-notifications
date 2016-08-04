package com.bubblewrap.notifications.alert;

import java.util.Date;

public class AdminAlert extends Alert {

	public AdminAlert(Object data, AlertType type) {
		super(data, new Date(), type);
	}

}
