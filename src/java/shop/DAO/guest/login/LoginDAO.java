/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shop.DAO.guest.login;


import java.sql.SQLException;
import shop.context.DBcontext;
import shop.model.Account;
import shop.model.Customer;

/**
 *
 * @author Admin
 */
public class LoginDAO extends DBcontext {
    
    public Account checkLoginAccount(String userName, String passWord) {
        Account account = null;
        connection = getConnection();

        try {
            String sql = """
                         SELECT [username]
                               ,[password]
                               ,[role]
                               ,[acc_status]
                         FROM [ClothingShopDB].[dbo].[Account]
                         WHERE [username] = ? AND [password] = ?""";
            
            statement = connection.prepareCall(sql);
            statement.setString(1, userName.trim());
            statement.setString(2,passWord);

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String userNameFinded = resultSet.getString(1);
                String passwordFinded = resultSet.getString(2);
                String role = resultSet.getString(3);
                String status = resultSet.getString(4);

                account = new Account(userNameFinded, passwordFinded, role, status);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return account;
    }

    public Customer getCustomer(String userName) {
        Customer customer = null;
        connection = getConnection();

        try {
            String sql = """
                         SELECT TOP (1000) [cus_id]
                               ,[cus_name]
                               ,[email]
                               ,[username]
                               ,[phone]
                               ,[address]
                           FROM [ClothingShopDB].[dbo].[Customer]
                         WHERE [username] = ?""";

            statement = connection.prepareCall(sql);
            statement.setString(1, userName.trim());
            
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                String username = resultSet.getString(4);
                String phone = resultSet.getString(5);
                String address = resultSet.getString(6);
                customer = new Customer(id, name, email, username, phone, phone, address);
            }
           
        } catch (SQLException e) {
            System.out.println(e);
        }

        return customer;
    }

    public static void main(String[] args) {
        LoginDAO loginDAO = new LoginDAO();
        Customer c = loginDAO.getCustomer("customer9");

        if (c != null) {
            System.out.println("Đăng nhập thành công!");
        } else {
            System.out.println("Sai tài khoản hoặc mật khẩu.");
        }
    }

}
