package com.study.redis.notice;

import com.study.redis.pubsub.publish.MessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.listener.Topic;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by rmcodestar on 2018. 11. 25..
 */
@RestController
public class NoticeController {
    @Autowired
    private MessagePublisher messagePublisher;

    @Autowired
    @Qualifier("noticeTopic")
    private Topic noticeTopic;

    @PostMapping("/notice")
    public void write(@RequestBody String notice) {
        messagePublisher.publish(noticeTopic.getTopic(), notice);
    }

}
