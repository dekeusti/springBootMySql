package com.ilse.springBootMySql.controller.user;

import com.ilse.springBootMySql.domain.user.User;
import com.ilse.springBootMySql.domain.user.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static com.ilse.springBootMySql.testConstants.UserTestConstants.user;
import static com.ilse.springBootMySql.testConstants.UserTestConstants.userWithId;
import static org.assertj.core.util.Lists.newArrayList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserControllerTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserController userController;

    @Test
    public void getAllUsers() {

        when(userRepository.findAll()).thenReturn((Iterable<User>) newArrayList(user()));

        userController.getAllUsers();
        verify(userRepository).findAll();
    }

    @Test
    public void addUser() {
        User user = user();
        userController.addNewUser(user.getName(),user.getEmail());
        verify(userRepository).save(user);
    }

    @Test
    public void updateUser() {
        when(userRepository.existsById(1)).thenReturn(true);
        userController.updateUser(1, "naam","email");
        verify(userRepository).save(userWithId());
    }
    @Test
    public void updateUser_withNonExistingId_throwsException() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("User to update does not exist with id " + 5);
        when(userRepository.existsById(5)).thenReturn(false);
        userController.updateUser(5, "naam","email");
    }

    @Test
    public void deleteUser() {
        when(userRepository.existsById(1)).thenReturn(true);
        userController.deleteUser(1);
        verify(userRepository).deleteById(1);
    }
    @Test
    public void deleteUser_withNonExistingId() {
        when(userRepository.existsById(5)).thenReturn(false);
        Assertions.assertThat(userController.deleteUser(5)).isEqualTo("User with id 5 to delete does not exist!");
    }
}