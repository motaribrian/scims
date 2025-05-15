package com.codewithmotari.scims;

import java.sql.SQLException;

public class UserService {
    private UserDao userDao;
    public UserService() {
        try {
            userDao=Factory.getUserDao();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Userr getUser(String username) throws SQLException {
        return userDao.getUserr(username);
    }
    public Userr getUser(int id) throws SQLException {

        return userDao.getUserr(id);
    }
}
