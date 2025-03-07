package net.gridplay.eoes.server;

import java.util.UUID;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
public class UdpServerHandler implements ChannelHandler {
	
	public void channelRead0(ChannelHandlerContext ctx, DatagramPacket packet) {
        System.out.println("Received: " + packet.content().toString(io.netty.util.CharsetUtil.UTF_8));
        ctx.writeAndFlush(packet); // Echo the received message back to the client
    }
	@Override
	public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		UUID cid =  UUID.randomUUID();
		ctx.writeAndFlush(cid);
	}

	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		// TODO Auto-generated method stub

	}

}
