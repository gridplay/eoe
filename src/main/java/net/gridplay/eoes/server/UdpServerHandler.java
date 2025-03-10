package net.gridplay.eoes.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import io.netty.util.CharsetUtil;
public class UdpServerHandler extends SimpleChannelInboundHandler<DatagramPacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket packet) throws Exception {
        ByteBuf buffer = Unpooled.copiedBuffer("Yolo", CharsetUtil.UTF_8);
        DatagramPacket responsePacket = new DatagramPacket(buffer, packet.sender());
        ctx.channel().writeAndFlush(responsePacket);
        String message = packet.content().toString(CharsetUtil.UTF_8);
        System.out.println("UDP Received: " + message);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
