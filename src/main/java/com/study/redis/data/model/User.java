package com.study.redis.data.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

/**
 * Created by rmcodestar on 2018. 11. 12..
 */
@Data
@RedisHash("user")
@AllArgsConstructor
public class User implements Serializable {
    @Id
    private String id;
    private String name;
}
