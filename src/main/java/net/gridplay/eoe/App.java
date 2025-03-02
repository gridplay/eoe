package net.gridplay.eoe;

import net.gridplay.eoe.server.EoEServer;

/**
 * Hello world!
 *
 */
public class App 
{
	static EoEServer eoes;
    public static void main( String[] args ) throws InterruptedException
    {
    	Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            Shutdown();
        }));
        System.out.println( "starting server on port 666" );
        eoes = new EoEServer();
        eoes.startserver(666);
    }
    private static void Shutdown() {
        System.out.println("Application is shutting down. Performing cleanup...");
    	eoes.stop();
    }
}
