package com.hucheng.service.impl;

import com.hucheng.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;

/**
 * @author HuChan
 */
@EnableBinding(Source.class) //定义消息的推送管道
public class MessageProvider implements IMessageProvider {

    @Autowired
    private MessageChannel output; // 消息发送管道

    @Override
    public String send() {
        String uuid = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(uuid).build());
        System.out.println("*****UUID: "  +uuid);
        return null;
    }
}
