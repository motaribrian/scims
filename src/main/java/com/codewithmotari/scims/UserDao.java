package com.codewithmotari.scims;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
