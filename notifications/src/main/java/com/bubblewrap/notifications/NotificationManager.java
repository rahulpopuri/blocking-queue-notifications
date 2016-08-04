package com.bubblewrap.notifications;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bubblewrap.notifications.message.Message;
import com.bubblewrap.notifications.message.MessageType;

public class NotificationManager {

	private int totalNotifications;
	private Map<MessageType, Notifier> notifierMap;
	private Map<MessageType, Thread> threadMap;

	private static NotificationManager INSTANCE;
	
	private static Logger log = LogManager.getLogger();

	/**
	 * Initialize Notifiers for each supported @MessageType
	 */
	private NotificationManager() {
		this.notifierMap = new HashMap<MessageType, Notifier>();
		this.threadMap = new HashMap<MessageType, Thread>();
		BlockingQueue<Message> queue;
		for (MessageType type : MessageType.values()) {
			queue = new LinkedBlockingQueue<Message>();
			Notifier n = NotifierFactory.getNotifier(type, queue);
			this.notifierMap.put(type, n);
			Thread t = new Thread(n);
			threadMap.put(type, t);
			t.start();
		}

		this.totalNotifications = 0;
	}

	public static NotificationManager getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new NotificationManager();
		}
		return INSTANCE;
	}

	public synchronized void addMessage(Message m) {
		if (!this.notifierMap.containsKey(m.getType())) {
			throw new IllegalArgumentException("Unsupported message type: " + m.getType());
		}
		try {
			this.notifierMap.get(m.getType()).getQueue().put(m);
			log.info("Added: " + m.getAlert() + " type: " + m.getType());
		} catch (Exception e) {
			e.printStackTrace();
		}
		totalNotifications++;
	}

	public int getTotalNotifications() {
		return totalNotifications;
	}

	/**
	 * Shutdown the notification manager and stop all associated threads
	 * 
	 * @throws InterruptedException
	 */
	public void stop() throws InterruptedException {
		for (MessageType t : threadMap.keySet()) {
			threadMap.get(t).interrupt();
		}
		log.info("Total messages processed: " + getTotalNotifications());
	}

}
