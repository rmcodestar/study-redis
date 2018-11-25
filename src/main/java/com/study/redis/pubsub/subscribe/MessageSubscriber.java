package com.study.redis.pubsub.subscribe;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    @Autowired
    @Qualifier("noticeTopic")
    private ChannelTopic topic;

    @Override
    public void onMessage(Message message, @Nullable byte[] pattern) {
        log.info("[subscribe] listen topic : {}, message : {}", topic.getTopic(), message);
    }
}
