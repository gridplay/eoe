package net.gridplay.eoes.server;

//import java.net.InetAddress;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
public class UdpServerHandler  extends  SimpleChannelInboundHandler<DatagramPacket> {

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket msg) throws Exception {
        //final InetAddress srcAddr = msg.sender().getAddress();
        final ByteBuf buf = msg.content();
        final int rcvPktLength = buf.readableBytes();
        final byte[] rcvPktBuf = new byte[rcvPktLength];
        buf.readBytes(rcvPktBuf);
        System.out.println("Inside incomming packet handler");
	}

}
