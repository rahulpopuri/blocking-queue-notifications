package com.bubblewrap.notifications.alert;

public class AlertFactory {

	public static Alert getAlert(Object data, AlertType type){
		switch(type) {
		case ADMIN:
			return new AdminAlert(data,type);
		default:
			throw new IllegalArgumentException("Unsupported Alert type: " + type);
		}
	}
}
