package com.study.redis.data.repository;

import com.study.redis.data.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by rmcodestar on 2018. 11. 12..
 */
public interface UserRepository extends CrudRepository<User, String> {
}
