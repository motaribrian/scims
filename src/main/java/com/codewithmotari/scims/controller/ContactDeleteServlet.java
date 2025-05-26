package com.codewithmotari.scims.controller;

import com.codewithmotari.scims.service.ContactService;
import com.codewithmotari.scims.util.Factory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ContactDeleteServlet extends HttpServlet {
    private final ContactService contactService;

    public ContactDeleteServlet() throws SQLException {
        this.contactService = Factory.getContactServiceimpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //if not authenticated
        if(req.getSession().getAttribute("username")==null){
            resp.sendRedirect("/login.jsp");
            return;
        }
        try {
            req.setAttribute("contact",contactService.getContact(Integer.parseInt(req.getParameter("id"))));
            int id= Integer.parseInt(req.getParameter("id"));
            contactService.deleteUser(id);
            RequestDispatcher dispatcher=req.getRequestDispatcher("/contactDelete.jsp");
            dispatcher.forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
            RequestDispatcher dispatcher=req.getRequestDispatcher("/ContactDeleteFailure.jsp");
            dispatcher.forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().print("<h1>post method</h1>");
    }
}
