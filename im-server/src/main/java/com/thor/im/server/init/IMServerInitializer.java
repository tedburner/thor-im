package com.thor.im.server.init;

import com.thor.im.server.handle.IMServerHandle;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.group.ChannelGroup;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;

/**
 * @author: lingjun.jlj
 * @date: 2021/6/15 10:32
 * @description:
 */
public class IMServerInitializer extends ChannelInitializer<Channel> {

    private final ChannelGroup group;

    public IMServerInitializer(ChannelGroup group) {
        this.group = group;
    }

    @Override
    protected void initChannel(Channel ch) throws Exception {
        ch.pipeline()
                .addLast(new HttpServerCodec())
                // google Protobuf 编解码
                .addLast(new ProtobufVarint32FrameDecoder())
                .addLast(new IMServerHandle());
    }
}
