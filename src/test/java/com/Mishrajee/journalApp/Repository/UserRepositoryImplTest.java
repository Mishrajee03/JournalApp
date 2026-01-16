package com.Mishrajee.journalApp.Repository;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRepositoryImplTest {

    @Autowired
    private UserRepoImpl userRepoImpl;

    @Disabled
    @Test
    public void testSaveNewUser(){
       userRepoImpl.getUserForSa();
    }
}
