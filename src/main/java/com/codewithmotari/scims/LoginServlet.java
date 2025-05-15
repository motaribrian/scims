package com.codewithmotari.scims;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {
    private UserService userService;

    public LoginServlet() {
        userService=Factory.getUserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        RequestDispatcher view=req.getRequestDispatcher("/login.jsp");
        view.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        try {
            boolean authenticated=validateLogin(username,password);
            if(authenticated){
                HttpSession session=req.getSession();
                session.setAttribute("username",username);
                resp.sendRedirect("/welcome");

            }
            //if not authentivated repeat the login
            else {
                RequestDispatcher view=req.getRequestDispatcher("/login.jsp");
                resp.sendRedirect("/login.jsp");
            }
        } catch (SQLException e) {
            //return user not found
            throw new RuntimeException(e);
        }
    }

    private boolean validateLogin(String username,String password) throws SQLException {
        Userr userr=userService.getUser(username);
        return username.equals(userr.getUsername()) && password.equals(userr.getPassword());
    }
}
