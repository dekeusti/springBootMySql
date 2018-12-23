package com.ilse.springBootMySql.controller;

import com.ilse.springBootMySql.controller.person.PersonController;
import com.ilse.springBootMySql.controller.user.UserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationSanityTest {

    @Autowired
    PersonController personController;

    @Autowired
    UserController userController;

    @Test
    public void applicationContextLoadsTest() throws Exception {
        assertThat(personController).isNotNull();
        assertThat(userController).isNotNull();
    }
}