package com.bubblewrap.notifications.alert;

import java.util.Date;

public abstract class Alert {

	protected AlertType type;
	protected Object data;
	protected Date date;
	protected String subject;

	/**
	 * Creates a new alert using the current timestamp
	 * @param data
	 */
	public Alert(Object data, AlertType type){
		this(data,new Date(),type);
	}
	
	/**
	 * Creates a new alert using the specified date object as timestamp
	 * @param data
	 * @param date
	 */
	public Alert(Object data, Date date, AlertType type) {
		this(data,date,"",type);
	}
	
	/**
	 * 
	 * @param data
	 * @param date
	 * @param subject
	 */
	public Alert(Object data, Date date, String subject, AlertType type){
		this.data = data;
		this.date = date;
		this.subject = subject;
		this.type = type;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public AlertType getType() {
		return type;
	}

	public void setType(AlertType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return this.subject + ":" + this.date + ":" + this.data;
	}

}
