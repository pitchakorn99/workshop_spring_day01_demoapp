package com.example.demoapp.users;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserGatewayTest {

    @Autowired
    private UserGateway userGateway;

    @Test
    public void getUserGateway(){
        Optional<Users> user = userGateway.getPostById(1);
        assertTrue(user.isPresent());
    }
}