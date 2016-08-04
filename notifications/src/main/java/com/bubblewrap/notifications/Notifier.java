package com.bubblewrap.notifications;

import java.util.concurrent.BlockingQueue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bubblewrap.notifications.message.Message;
import com.bubblewrap.notifications.message.MessageType;

public abstract class Notifier implements Runnable {

	private static Logger log = LogManager.getLogger();

	protected int totalCount;
	protected MessageType type;
	protected BlockingQueue<Message> notifications;

	public Notifier(MessageType type, BlockingQueue<Message> queue) {
		this.type = type;
		this.notifications = queue;
		this.totalCount = 0;
	}

	public void run() {
		log.info("Starting " + this.type + " notifier");
		while (!Thread.currentThread().isInterrupted()) {
			try {
				Message m = notifications.take();
				process(m);
				this.totalCount++;
				Thread.sleep(200);
			} catch (InterruptedException e) {
				log.info("Stopping " + this.type + " notifier, processed " + getTotalCount() + " messages");
				return;
			}
		}
	}

	public BlockingQueue<Message> getQueue() {
		return this.notifications;
	}

	public int getTotalCount() {
		return this.totalCount;
	}

	protected abstract void process(Message m);
}
