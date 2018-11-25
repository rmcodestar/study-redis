package com.study.redis.datatype;

import com.study.redis.datatype.model.User;
import com.study.redis.datatype.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommandTest {
    @Resource(name = "redisTemplate")
    private ValueOperations<String, String> stringOperations;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testStringCommand() {
        //Given
        stringOperations.set("mykey", "myvalue");

        //Wheb
        String value = stringOperations.get("mykey");

        //Then
        assertThat(value, is("myvalue"));
    }

    @Test
    public void testRepository() {
        //Given
        String id = "NO123";
        User user = new User(id, "rmcodesgtar");

        //When
        userRepository.save(user);

        //then
        System.out.println(userRepository.findById(id));
    }
}
