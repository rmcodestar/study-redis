package com.study.redis.subscribe;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Created by rmcodestar on 2018. 11. 12..
 */
@Slf4j
@Component
public class MessageSubscriber extends MessageListenerAdapter {
    @Getter
    private ChannelTopic topic = new ChannelTopic("redis-study:channel1");

    @Override
    public void onMessage(Message message, @Nullable byte[] pattern) {
        log.info("[subscribe] listen topic : {}, message : {}", topic.getTopic(), message);
    }
}
