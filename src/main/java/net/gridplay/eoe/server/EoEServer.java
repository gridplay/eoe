package net.gridplay.eoe.server;

public class EoEServer {
	public void startserver(int port) {
		try {
			new TCP(port).start();
			new UDP(port).start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
