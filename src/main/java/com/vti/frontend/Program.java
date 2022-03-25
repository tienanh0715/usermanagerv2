package com.vti.frontend;

import com.vti.entity.Role;
import com.vti.entity.User;
import com.vti.utils.ScannerUtils;

import java.io.IOException;
import java.sql.SQLException;

public class Program {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        menuLogin();
    }

    public static void menuLogin() throws SQLException, IOException, ClassNotFoundException {
        Function function = new Function();

        System.out.println("Mời bạn đăng nhập");
        User user = function.login();

        if (user.getRole() == Role.Admin){
            menuAdmin();
        } else{
            menuEmployee();
        }
    }

    public static void menuEmployee() throws SQLException, IOException, ClassNotFoundException {
        Function function = new Function();

        while(true){
            displayMenuEmployee();
            System.out.print("Mời bạn nhập chức năng: ");
            int choose = ScannerUtils.inputFunction(1,3, "Bạn phải nhập chức năng từ 1 - 3, mời nhập lại!");

            switch (choose){
                case 1:
                    function.getListUsers();
                    break;
                case 2:
                    function.getUserById();
                    break;
                case 3:
                    System.out.println("Tạm biệt và hẹn gặp lại!");
                    return;
            }
        }
    }

    public static void displayMenuEmployee(){
        System.out.println("1 - Hiển thị danh sách các user");
        System.out.println("2 - Tìm kiếm user theo id");
        System.out.println("3 - Thoát khỏi chương trình");
    }

    public static void menuAdmin() throws SQLException, IOException, ClassNotFoundException {
        Function function = new Function();

        while (true){
            displayMenuAdmin();
            System.out.print("Mời bạn nhập chức năng: ");
            int choose =ScannerUtils.inputFunction(1,5,"Bạn phải nhập chức năng từ 1 - 5, mời bạn nhập lại!");

            switch (choose){
                case 1:
                    function.getListUsers();
                    break;
                case 2:
                    function.getUserById();
                    break;
                case 3:
                    function.deleteUser();
                    break;
                case 4:
                    function.addUser();
                    break;
                case 5:
                    System.out.println("Tạm biệt và hẹn gặp lại");
                    return;
            }
        }
    }

    public static void displayMenuAdmin(){
        System.out.println("1 - Hiển thị danh sách các user");
        System.out.println("2 - Tìm kiếm user theo id");
        System.out.println("3 - Xóa user theo id");
        System.out.println("4 - Thêm user");
        System.out.println("5 - Thoát khỏi chương trình");
    }
}
