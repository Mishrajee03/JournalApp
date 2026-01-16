package com.Mishrajee.journalApp.Service;


import com.Mishrajee.journalApp.Repository.UserRepo;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserRepo userRepo;

    @Disabled
    @Test
    public void testFindByUserName(){
        assertNotNull(userRepo.findByUserName("ram"));
    }
}
