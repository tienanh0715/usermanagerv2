package com.vti.backend.presentationlayer;

import com.vti.backend.businesslayer.IUserService;
import com.vti.backend.businesslayer.UserService;
import com.vti.entity.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UserController {
    private IUserService userService;

    public UserController() {
        userService = new UserService();
    }

    public List<User> getListUsers() throws SQLException, IOException, ClassNotFoundException {
        return userService.getListUsers();
    }

    public User getUserById(int id) throws SQLException, IOException, ClassNotFoundException {
        return userService.getUserById(id);
    }

    public int deleteUser(int id) throws SQLException, IOException, ClassNotFoundException {
        return userService.deleteUser(id);
    }

    public boolean isUserIdExists(int id) throws SQLException, IOException, ClassNotFoundException {
        return userService.isUserIdExists(id);
    }

    public User login(String email, String password) throws SQLException, IOException, ClassNotFoundException {
        return userService.login(email, password);
    }

    public int addUser(String fullName, String email) throws SQLException, IOException, ClassNotFoundException {
        return userService.addUser(fullName, email);
    }
}
