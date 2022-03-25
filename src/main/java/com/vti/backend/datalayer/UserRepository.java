package com.vti.backend.datalayer;

import com.vti.entity.Admin;
import com.vti.entity.Employee;
import com.vti.entity.Role;
import com.vti.entity.User;
import com.vti.utils.JDBCUtils;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class UserRepository implements IUserRepository{

    private JDBCUtils jdbcUtils;
    private Connection connection;

    public UserRepository() {
        jdbcUtils = new JDBCUtils();
    }


    @Override
    public List<User> getListUsers() throws SQLException, IOException, ClassNotFoundException {
        List<User> listUser = new ArrayList<>();

        try{
            //get connection
            connection = jdbcUtils.getConnection();

            //create a statement object
            Statement statement = connection.createStatement();

            //excecute query
            String sql = "SELECT Id, FullName, Email FROM User";
            ResultSet resultSet = statement.executeQuery(sql);

            //handling result set
            while (resultSet.next()){
                int id = resultSet.getInt("Id");
                String fullName = resultSet.getString("FullName");
                String email = resultSet.getString("Email");
                listUser.add(new User(id, fullName, email));
            }
            return listUser;
        } finally {
            jdbcUtils.disconnect();
        }
    }

    @Override
    public User getUserById(int id) throws SQLException, IOException, ClassNotFoundException {
        try{
            //get connection
            connection = jdbcUtils.getConnection();

            //create a statement object
            String sql = "SELECT Id, FullName, Email, Role, ExpInYear, ProSkill FROM User WHERE Id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            //set parameter
            preparedStatement.setInt(1, id);

            //excecute query
            ResultSet resultSet = preparedStatement.executeQuery();

            //handling result set
            if (resultSet.next()){
                int userId = resultSet.getInt("Id");
                String fullName = resultSet.getString("FullName");
                String email = resultSet.getString("Email");
                String role = resultSet.getString("Role");

                if (role.equals("Admin")){
                    int expInYear = resultSet.getInt("ExpInYear");
                    User admin = new Admin(userId, fullName, email, expInYear);
                    return admin;
                } else {
                    String proSkill = resultSet.getString("ProSkill");
                    User employee = new Employee(userId, fullName, email, proSkill);
                    return employee;
                }

            } else {
                return null;
            }
        } finally {
            jdbcUtils.disconnect();
        }
    }

    @Override
    public int deleteUser(int id) throws SQLException, IOException, ClassNotFoundException {
        try{
            //get connection
            connection = jdbcUtils.getConnection();

            //create a statement object
            String sql = "DELETE FROM User WHERE Id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            //set parameter
            preparedStatement.setInt(1, id);

            //excecute update
            int effectedRecordAmount = preparedStatement.executeUpdate();

            //handling result
            return effectedRecordAmount;
        } finally {
            jdbcUtils.disconnect();
        }
    }

    @Override
    public boolean isUserIdExists(int id) throws SQLException, IOException, ClassNotFoundException {
        try{
            //get connection
            connection = jdbcUtils.getConnection();

            //create a statement object
            String sql = "SELECT * FROM User WHERE Id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            //set parameter
            preparedStatement.setInt(1, id);

            //excecute execute
            ResultSet resultSet = preparedStatement.executeQuery();

            //handling result set
            if (resultSet.next()){
                return true;
            } else{
                return false;
            }
        } finally {
            jdbcUtils.disconnect();
        }
    }

    @Override
    public User login(String email, String password) throws SQLException, IOException, ClassNotFoundException {
        try {
            //get connection
            connection = jdbcUtils.getConnection();

            //create a statement object
            String sql = "SELECT Id, FullName, Role FROM User WHERE (Email = ? AND Password = ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            //set parameter
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            //excecute execute
            ResultSet resultSet = preparedStatement.executeQuery();

            //handling result set
            if (resultSet.next()){
                int id = resultSet.getInt("Id");
                String fullName = resultSet.getString("FullName");
                String role = resultSet.getString("Role");

                if (role.equals("Admin")) {
                    User admin = new Admin(id, fullName, email, Role.Admin);
                    return admin;
                } else {
                    User employee = new Employee(id, fullName, email, Role.Employee);
                    return employee;
                }
            } else{
                return null;
            }
        } finally {
            jdbcUtils.disconnect();
        }
    }

    @Override
    public int addUser(String fullName, String email) throws SQLException, IOException, ClassNotFoundException {
        try {
            //get connection
            connection = jdbcUtils.getConnection();

            //create a statement object
            String sql = "INSERT INTO User(FullName, Email, Password) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            //set parameter
            preparedStatement.setString(1, fullName);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, "123456");

            //excecute update
            int effectedRecordAmount = preparedStatement.executeUpdate();

            //handling result
            return effectedRecordAmount;
        } finally {
            jdbcUtils.disconnect();
        }
    }
}
