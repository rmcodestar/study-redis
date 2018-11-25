package com.study.redis.config;

import com.study.redis.pubsub.subscribe.MessageSubscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

import java.util.concurrent.Executors;

/**
 * Created by rmcodestar on 2018. 11. 12..
 */
@Configuration
@EnableRedisRepositories
public class RedisConfigurer {
    @Value("${spring.redis.host}")
    private String redisHost;

    @Value("${spring.redis.port}")
    private int redisPort;

    @Autowired
    private MessageSubscriber messageSubscriber;

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        return new LettuceConnectionFactory(redisHost, redisPort);
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        final RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory());
        template.setValueSerializer(new GenericToStringSerializer<>(Object.class));
        return template;
    }

    @Bean
    public RedisMessageListenerContainer redisContainer(@Autowired MessageSubscriber messageSubscriber, @Autowired ChannelTopic noticeTopic) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();

        container.setConnectionFactory(redisConnectionFactory());
        container.addMessageListener(messageSubscriber, noticeTopic);
        container.setTaskExecutor(Executors.newFixedThreadPool(4));

        return container;
    }

    @Bean
    public MessageSubscriber messageSubscriber() {
        return new MessageSubscriber(noticeTopic());
    }

    @Bean
    public ChannelTopic noticeTopic() {
        return new ChannelTopic("topic:notice");
    }
}
