package com.codewithmotari.scims.service;

import com.codewithmotari.scims.repository.UserDao;
import com.codewithmotari.scims.model.Userr;
import com.codewithmotari.scims.util.Factory;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private UserDao userDao;
    public UserService() {
        try {
            userDao= Factory.getUserDao();
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

    public List<Userr> getAllUsers() throws SQLException {
        return userDao.getAllUsers();
    }

    public Userr addUser(Userr user) throws SQLException {
        return userDao.addUser(user);
    }
}
