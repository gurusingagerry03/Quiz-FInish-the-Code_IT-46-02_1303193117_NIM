/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.latihanwebmvc.Model;

import com.mycompany.latihanwebmvc.Database.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author helmy
 */
public class User {

    private int id;
    private String username;
    private String password;
    private String fullName;

    public User() {
    }

    public User(String username, String password, String fullName) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
    }

    public User(int id, String username, String password, String fullName) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
    }

     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isValidUser() throws SQLException {
    String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (Connection conn = DBUtil.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, this.username);  
            stmt.setString(2, this.password);  
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                this.id = rs.getInt("id");
                this.fullName = rs.getString("fullName");
                return true;
            }
        }
        return false;
    }



}
