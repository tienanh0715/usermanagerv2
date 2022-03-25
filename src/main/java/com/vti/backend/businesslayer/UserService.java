package com.vti.backend.businesslayer;

import com.vti.backend.datalayer.IUserRepository;
import com.vti.backend.datalayer.UserRepository;
import com.vti.entity.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UserService implements IUserService{
    private IUserRepository userRepository;

    public UserService() {
        userRepository = new UserRepository();
    }

    @Override
    public List<User> getListUsers() throws SQLException, IOException, ClassNotFoundException {
        return userRepository.getListUsers();
    }

    @Override
    public User getUserById(int id) throws SQLException, IOException, ClassNotFoundException {
        return userRepository.getUserById(id);
    }

    @Override
    public int deleteUser(int id) throws SQLException, IOException, ClassNotFoundException {
        return userRepository.deleteUser(id);
    }

    @Override
    public boolean isUserIdExists(int id) throws SQLException, IOException, ClassNotFoundException {
        return userRepository.isUserIdExists(id);
    }

    @Override
    public User login(String email, String password) throws SQLException, IOException, ClassNotFoundException {
        return userRepository.login(email, password);
    }

    @Override
    public int addUser(String fullName, String email) throws SQLException, IOException, ClassNotFoundException {
        return userRepository.addUser(fullName, email);
    }
}
