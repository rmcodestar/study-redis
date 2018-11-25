package com.study.redis.pubsub.subscribe;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

/**
 * Created by rmcodestar on 2018. 11. 12..
 */
@Slf4j
public class MessageSubscriber extends MessageListenerAdapter {
    private ChannelTopic topic;

    @Autowired
    public MessageSubscriber(ChannelTopic topic) {
        this.topic = topic;
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        log.info("[subscribe] listen topic : {}, message : {}", topic.getTopic(), message);
    }
}
