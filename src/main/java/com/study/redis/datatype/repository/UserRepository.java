package com.study.redis.datatype.repository;

import com.study.redis.datatype.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by rmcodestar on 2018. 11. 12..
 */
public interface UserRepository extends CrudRepository<User, String> {
}
