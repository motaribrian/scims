package com.codewithmotari.scims;

import java.sql.SQLException;
import java.util.List;

public class AdminService {
    private List<Userr> users;

    public AdminService() throws SQLException {
        users = Factory.getUserService().getAllUsers();
    }

}
