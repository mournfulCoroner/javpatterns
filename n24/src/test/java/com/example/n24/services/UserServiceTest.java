package com.example.n24.services;

import com.example.n24.dao.UserDAO;
import com.example.n24.models.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserDAO userDAO;
    @Captor
    ArgumentCaptor<User> captor;

    @Test
    public void getUser() {
        User user = new User();
        User user2 = new User();

        user2.setUsername("Alya");
        user.setUsername("Kel");
        Mockito.when(userDAO.findByUsername("Alya")).thenReturn(user);
        Mockito.when(userDAO.findByUsername("Kel")).thenReturn(user2);

        UserService userService = new UserService(userDAO);

        Assertions.assertEquals("Alya", userService.getUser("Alya").getUsername()
        );
        Assertions.assertEquals("Kel", userService.getUser("Kel").getUsername()
        );

    }

    @Test
    public void save() {
        User user = new User();
        user.setUsername("Mur");

        UserService userService = new UserService(userDAO);
        userService.save(user);

        Mockito.verify(userDAO).save(captor.capture());

        User captured = captor.getValue();
        Assertions.assertEquals("Mur", captured.getUsername());
    }
}