package com.codewithmotari.scims;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        Object username=  session.getAttribute("username");
        //if a user ain't authenticated
        if(username==null){
            resp.sendRedirect("/login.jsp");

        }
        //if a user is authenticated
        else{
            List<Contact> list = null;
            try {
                int userId=Factory.getUserService().getUser(username.toString()).getId();
                list=Factory.getContactServiceimpl().getContactbyUser(userId);

                System.out.println(list.size());
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("empty list passed");

            }
            try {
                session.setAttribute("contacts",list);
                System.out.println("added the list to the request " +session.getAttribute("contacts"));
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("failed to add the list to the request");
            }
            System.out.println("again :"+session.getAttribute("contacts"));
            req.getRequestDispatcher("welcome.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
