package com.codewithmotari.scims;

import net.sf.jasperreports.engine.JasperPrintManager;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ContactsPrintServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object username = request.getSession().getAttribute("username");
        if(username==null){
            System.out.println("user not authenticated welcomeservletdoget");
            response.sendRedirect("/login.jsp");
            return;
        }
            JasperReportService jasperReportService = new JasperReportService();
            byte[] pdf=jasperReportService.exportpdf(request.getParameter("county"),request.getParameter("gender"), (String) username);
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
