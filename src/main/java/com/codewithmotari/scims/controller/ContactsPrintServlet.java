package com.codewithmotari.scims.controller;

import com.codewithmotari.scims.service.JasperReportService;
import com.codewithmotari.scims.service.UserService;
import com.codewithmotari.scims.util.Factory;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.SQLException;

public class ContactsPrintServlet extends HttpServlet {
    public UserService userService;

    public ContactsPrintServlet() {
        this.userService = Factory.getUserService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object username = request.getSession().getAttribute("username");
        if(username==null){
            System.out.println("user not authenticated welcomeservletdoget");
            response.sendRedirect("/login.jsp");
            return;
        }
        int userId;
        try {
            userId = userService.getUser((String) username).getId();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

            JasperReportService jasperReportService = new JasperReportService();
            byte[] pdf=jasperReportService.exportpdf(userId,request.getParameter("county"),request.getParameter("gender"), (String) username);
            response.setContentType("application/pdf");
            String filepath = System.getProperty("user.home")+"/reports/contactsReport.pdf";
            response.setHeader("Content-Disposition", "inline; filename=contactsReport.pdf");
            response.setContentLength((int) pdf.length);

            OutputStream out = response.getOutputStream();
            out.write(pdf);

            }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
