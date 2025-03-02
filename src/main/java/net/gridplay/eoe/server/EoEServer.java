package net.gridplay.eoe.server;

public class EoEServer {
	TCP tcp;
	UDP udp;
	public void startserver(int port) throws InterruptedException {
		tcp = new TCP(port);
		udp = new UDP(port);
		Thread tcpThread = new Thread(() -> {
            try {
                tcp.start();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        /*Thread udpThread = new Thread(() -> {
            try {
                udp.start();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });*/

        tcpThread.start();
        //udpThread.start();
	}
	public void stop() {
		tcp.close();
		udp.close();
	}
}
