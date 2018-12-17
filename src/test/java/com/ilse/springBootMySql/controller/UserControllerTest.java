package com.ilse.springBootMySql.controller;

import com.ilse.springBootMySql.domain.User;
import com.ilse.springBootMySql.domain.UserRepository;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Iterator;

import static com.ilse.springBootMySql.testConstants.UserTestConstants.user;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;
import static org.mockito.Mockito.when;

public class UserControllerTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    private UserRepository userRepository;

    @Mock
    private EntityManager entityManager;

    @InjectMocks
    private UserController userController;

    @Test
    public void addUser() {

        when(userRepository.findAll()).thenReturn((Iterable<User>) newArrayList(user()));

        assertThat(userController.getAllUsers()).contains(user());
    }
}