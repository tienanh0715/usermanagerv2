package com.vti.backend.datalayer;

import com.vti.entity.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IUserRepository {
    public List<User> getListUsers() throws SQLException, IOException, ClassNotFoundException;

    public User getUserById(int id) throws SQLException, IOException, ClassNotFoundException;

    public int deleteUser(int id) throws SQLException, IOException, ClassNotFoundException;

    public boolean isUserIdExists(int id) throws SQLException, IOException, ClassNotFoundException;

    public User login(String email, String password) throws SQLException, IOException, ClassNotFoundException;

    public int addUser(String fullName, String email) throws SQLException, IOException, ClassNotFoundException;
}
