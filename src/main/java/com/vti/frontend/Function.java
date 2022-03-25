package com.vti.frontend;

import com.vti.backend.datalayer.UserRepository;
import com.vti.backend.presentationlayer.UserController;
import com.vti.entity.User;
import com.vti.utils.ScannerUtils;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Function {
    private UserController userController;

    public Function() {
        userController = new UserController();
    }

    public void getListUsers() throws SQLException, IOException, ClassNotFoundException {
        List<User> listUsers = userController.getListUsers();

        System.out.printf("%-15s %-25s %-25s\n", "ID", "Email", "Fullname");
        for (User user : listUsers) {
            System.out.printf("%-15s %-25s %-25s\n", user.getId(), user.getEmail(), user.getFullName());
        }
    }

    public void getUserById() throws SQLException, IOException, ClassNotFoundException {
        while (true) {
            System.out.print("Mời bạn nhập Id cần tìm: ");
            int id = ScannerUtils.inputPositiveInt("Bạn phải nhập vào số nguyên dương! Mời bạn nhập lại!");
            User user = userController.getUserById(id);

            if (user != null) {
                System.out.println(userController.getUserById(id));
                return;
            } else {
                System.err.println("Không tìm thấy user có id: " + id);
            }
        }
    }

    public void deleteUser() throws SQLException, IOException, ClassNotFoundException {
        while (true){
            System.out.print("Mời bạn nhập Id cần xóa: ");
            int id = ScannerUtils.inputPositiveInt("Bạn phải nhập vào số nguyên dương! Mời bạn nhập lại!");
            boolean check = userController.isUserIdExists(id);
            if (check){
                userController.deleteUser(id);
                System.out.println("Xóa thành công user có id: " + id);
                return;
            } else {
                System.err.println("Không tìm thấy user có id: " + id);
            }
        }
    }

    public User login() throws SQLException, IOException, ClassNotFoundException {
        while (true) {
            System.out.print("Mời bạn nhập email: ");
            String email = ScannerUtils.inputEmail("Nhập sai định dạng email");
            System.out.print("Mời bạn nhập password: ");
            String password = ScannerUtils.inputPassword("Password từ 6 - 12 ký tự và có ít nhất một ký tự viết hoa");

            User user = userController.login(email, password);

            if (user != null){
                System.out.printf("Chào mừng %s (%s) \n \n", user.getFullName(), user.getRole());
                return user;
            } else {
                System.err.println("Bạn đã điền email/password chưa đúng, mời bạn nhập lại!");
            }
        }
    }

    public void addUser() throws SQLException, IOException, ClassNotFoundException {
        System.out.print("Mời bạn nhập Full name: ");
        String fullName = ScannerUtils.isStringContainsSpecialCharacter("Tên chỉ chứa chữ, không chứa ký tự đặc biệt");
        System.out.print("Mời bạn nhập Email: ");
        String email = ScannerUtils.inputEmail("Email chưa đúng định dạng!");

        userController.addUser(fullName, email);
        System.out.println("Đã thêm user: " + fullName);
        }
}
