package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.util.DBUtil;
import com.model.LoginModel;

public class UserDao {

    private Connection conn;

    public UserDao() {
        conn = DBUtil.getConnection();//connect to database
    }
    //Validates login with user input

    public boolean validateLogin(String em, String pw) {
        boolean canLogin = false;

        //Search database for email and password and return true if found
        try {
            PreparedStatement ps = conn
                    .prepareStatement("select * from Users where username=? and psword=?");
            ps.setString(1, em);
            ps.setString(2, pw);

            ResultSet rs = ps.executeQuery();
            canLogin = rs.next(); //true if found else false
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return canLogin;
    }

    //returns user info from specified email for session
    public LoginModel userSession(String em) {
        LoginModel user = new LoginModel(); //create new user object
        try {
            PreparedStatement ps = conn
                    .prepareStatement("select * from Users where username=?");//search database for email
            ps.setString(1, em);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user.setUserName(rs.getString("username"));
                user.setFullName(rs.getString("fullname"));
                user.setPsword(rs.getString("psword"));
                user.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    //Creates a new user with input data
    public void createUser(LoginModel user) {
        try {
            PreparedStatement ps = conn
                    .prepareStatement("insert into Users(username,fullname,psword,email) values (?,?,?,?)");//add user to database
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getFullName());
            ps.setString(3, user.getPsword());
            ps.setString(4, user.getEmail());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //update user with input data

    public void editAccount(LoginModel user) {
        try {
            PreparedStatement ps = conn
                    .prepareStatement("update Users set fullname=?, psword=?, email=? where username=?"); //find user with id and update info
            ps.setString(1, user.getFullName());
            ps.setString(2, user.getPsword());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getUserName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Remove user from database with specified id
    public void deleteAccount(String username) {
        try {
            PreparedStatement ps = conn
                    .prepareStatement("delete from Users where username=?");
            ps.setString(1, username);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //returns a list of all users
    public List<LoginModel> listUsers() {
        List<LoginModel> userList = new ArrayList<LoginModel>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from Users");
            while (rs.next()) {
                LoginModel user = new LoginModel();
                user.setUserName(rs.getString("username"));
                user.setFullName(rs.getString("fullname"));
                user.setPsword(rs.getString("psword"));
                user.setEmail(rs.getString("email"));
                userList.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }

    //returns user info from specified id
    public LoginModel getUserByUserName(String username) {
        LoginModel user = new LoginModel();
        try {
            PreparedStatement ps = conn
                    .prepareStatement("select * from Users where username= ?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user.setUserName(rs.getString("username"));
                user.setFullName(rs.getString("fullname"));
                user.setPsword(rs.getString("psword"));
                user.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}
