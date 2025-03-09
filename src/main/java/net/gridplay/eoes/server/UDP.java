package net.gridplay.eoes.server;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;
public class UDP {
	private final int port;
    EventLoopGroup group;
	public UDP(int port) {
		this.port = port;
	}
	public void start() throws InterruptedException {
		group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                .channel(NioDatagramChannel.class)
                .option(ChannelOption.SO_BROADCAST, true)
                .handler(new ChannelInitializer<NioDatagramChannel>() {
                    @Override
                    protected void initChannel(NioDatagramChannel ch) throws Exception {
                        ch.pipeline().addLast(new UdpServerHandler());
                    }
                });
            ChannelFuture f = b.bind((port + 1)).sync();
            f.channel().closeFuture().await();
        } catch(Exception e) {
        	e.printStackTrace();
        	System.out.println("UDP ERROR!");
        }
    }
	public void close() {
        group.shutdownGracefully();
	}
}
