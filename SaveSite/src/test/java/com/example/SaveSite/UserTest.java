package com.example.SaveSite;

import com.example.SaveSite.Entity.User;
import com.example.SaveSite.Repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;


import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class UserTest {
/*
    @Autowired
    private UserRepository userRepository;

    @AfterEach
    public void cleanup() {
        userRepository.deleteAll();
    }

    @Test
    public void creation() {
        User user1 = new User("user1", "user1@example.com", "password1");
        userRepository.save(user1);

    }

    @Test
    public void testUniqueLoginAndEmail() {
        User user1 = new User("user1", "user1@example.com", "password1");
        userRepository.save(user1);

        User user2 = new User("user1", "user2@example.com", "password2");
        assertThrows(DuplicateKeyException.class, () -> userRepository.save(user2));

        User user3 = new User("user3", "user1@example.com", "password3");
        assertThrows(DuplicateKeyException.class, () -> userRepository.save(user3));
    }*/
}
