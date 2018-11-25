package com.study.redis.pubsub;

import com.study.redis.pubsub.publish.MessagePublisher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PubSubTest {
    @Autowired
    private MessagePublisher messagePublisher;

    @Test
    public void testPublish() {
        messagePublisher.publish("redis-study:channel1", "hello, world!");
        messagePublisher.publish("redis-study:channel2", "hello, world!");
    }

}
