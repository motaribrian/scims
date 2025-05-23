package com.codewithmotari.scims;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
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
            System.out.println("user not authenticated welcomeservletdoget");
            resp.sendRedirect("/login.jsp");

        }
        //if a user is authenticated
        else{

            List<Contact> list,list2 = null;
            try {
                int userId=Factory.getUserService().getUser(username.toString()).getId();
                list=Factory.getContactServiceimpl().getContactbyUser(userId);
                String param1=req.getParameter("gender") != null ? req.getParameter("gender") : "" ;
                String param2=req.getParameter("county" ) != null ? req.getParameter("county") : "" ;
                list2=Factory.getContactServiceimpl().filterByGenderAndCounty(list,param1,param2);
            } catch (SQLException e) {
                e.printStackTrace();

            }
            try {
                session.setAttribute("contacts",list2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            req.getRequestDispatcher("welcome.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //doGet(req,resp);

    }
}
