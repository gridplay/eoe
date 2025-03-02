package net.gridplay.eoe;

import net.gridplay.eoe.server.EoEServer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "starting server" );
        new EoEServer().startserver(666);
    }
}
