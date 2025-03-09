package net.gridplay.eoes.server;

import java.net.InetSocketAddress;

public class Message {
	String Message;
	InetSocketAddress sender;

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public void setSender(InetSocketAddress sender) {
		this.sender = sender;
	}
	
	public InetSocketAddress getSender() {
		return this.sender;
	}
}
