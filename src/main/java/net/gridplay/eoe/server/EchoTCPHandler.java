package net.gridplay.eoe.server;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;

public class EchoTCPHandler implements ChannelHandler {

	@Override
	public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		// TODO Auto-generated method stub

	}
	public void channelRead(ChannelHandlerContext ctx, Object msg) {
        System.out.println("Received: " + msg);
        ctx.write(msg); // Echo the received message back to the client
    }

    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush(); // Flush all previous written messages to the remote peer
    }
}
