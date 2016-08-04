package com.bubblewrap.notifications.message.email;

/**
 * Enum for types of emails sent out.
 * Every enum must have a subject defined in PROP_FILE_EMAIL from Config.java
 * @author Rahul
 *
 */
public enum EmailType {
	DAILY_OPTIONS_LOAD,
	EOD_STOCK_LOAD,
	UNKNOWN_ERROR,
	ADD_SYMBOL,
	ADMIN,
	EARNINGS,
	DB_BACKUP,
	OPTION_COPY_FORWARD,
	STOCK_COPY_FORWARD,
	OTHER
}
