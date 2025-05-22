package com.codewithmotari.scims;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class UsersServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path= req.getRequestURI();
        if (path.equals("/users/signup")) {
            try {
                Userr user = new Userr();
                user.setUsername(req.getParameter("username"));
                user.setPassword(req.getParameter("password"));
                user.setRole("USER");
                user.setFullName(req.getParameter("fullname"));
                Factory.getUserService().addUser(user);
                System.out.println("User created");

            } catch (SQLException e) {
                doGet(req, resp);
                //throw new RuntimeException(e);
                return;

            }
            resp.sendRedirect("/");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path= req.getRequestURI();
;

        if (path.equals("/users/signup")) {
            req.getRequestDispatcher("/signup.jsp").forward(req, resp);
            return;
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }
}
