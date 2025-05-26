package com.codewithmotari.scims.repository;

import com.codewithmotari.scims.model.Userr;
import com.codewithmotari.scims.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private final Connection con;

    public UserDao() throws SQLException {
        con = DBConnection.getConnection();
    }

    public Userr getUserr(int id) throws SQLException {
        Userr userr=new Userr();
        String query="select * from userrs where id="+id;
        PreparedStatement ps=con.prepareStatement(query);
        ResultSet rs=ps.executeQuery();
        if (rs.next()){
            userr.setUsername(rs.getString("user_name"));
            userr.setId(rs.getInt("user_id"));
        }

        return userr;}

    public Userr getUserr(String username) throws SQLException {
        Userr user=new Userr();



        String query = "SELECT * FROM userrs WHERE user_name = ?";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setString(1, username);
        ResultSet rs = stmt.executeQuery();






            if (rs.next()){
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("user_name"));
                user.setPassword(rs.getString("password"));
            }

        return user;

    }

    public List<Userr> getAllUsers() throws SQLException {
        List<Userr> users=new ArrayList<>();
        String query="select * from userrs";
        PreparedStatement stmt=con.prepareStatement(query);
        ResultSet rs=stmt.executeQuery();

        while (rs.next()){
            Userr userr=new Userr(rs.getInt("id"), rs.getString("user_name"));
            users.add(userr);
        }
        return users;

    }

    public Userr addUser(Userr user) throws SQLException {
        String query = "INSERT INTO userrs (fullName, user_name, password , role) values (?,?,?,?)";
        PreparedStatement stmt= con.prepareStatement(query);
        stmt.setString(1,user.getFullName());
        stmt.setString(2,user.getUsername());
        stmt.setString(3,user.getPassword());
        stmt.setString(4,user.getRole());
        int result=stmt.executeUpdate();
        stmt.close();
        if (result==0){
            return null;
        }
        return user;
    }
}
