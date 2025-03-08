package net.gridplay.eoes.server;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
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
                .option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT)
                .handler(new ChannelInitializer<NioDatagramChannel>() {
					@Override
					protected void initChannel(NioDatagramChannel ch) throws Exception {
						ChannelPipeline p = ch.pipeline();
	                    p.addLast(new UdpServerHandler());
					}
                });
            b.bind(port).sync().channel().closeFuture().await();
        } catch(Exception e) {
        	System.out.println("UDP ERROR!");
        }
    }
	public void close() {
        group.shutdownGracefully();
	}
}
