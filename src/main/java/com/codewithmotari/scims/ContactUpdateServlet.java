package com.codewithmotari.scims;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

public class ContactUpdateServlet extends HttpServlet {
    private ContactService contactservice;
    private UserService userService;

    public ContactUpdateServlet() throws SQLException {
        contactservice = Factory.getContactServiceimpl();
        userService=Factory.getUserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //if not authenticated
        if(req.getSession().getAttribute("username")==null){
            resp.sendRedirect("/login.jsp");
            return;
        }
        try {
            req.setAttribute("contact",contactservice.getContact(Integer.parseInt(req.getParameter("id"))));
            RequestDispatcher dispatcher=req.getRequestDispatcher("/contactUpdate.jsp");
            dispatcher.forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
            RequestDispatcher dispatcher=req.getRequestDispatcher("/contactUpdateFailure.jsp");
            dispatcher.forward(req,resp);
        }

    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("you hit the method");
        HttpSession session = request.getSession();
        Object username = session.getAttribute("username");

        if (username == null) {

            RequestDispatcher rd = request.getRequestDispatcher("/");
            rd.forward(request, response);
        }
        System.out.println("username is not null");
        int userId;
        try {
            userId = userService.getUser((String) username).getId();

            String fullName = (String) request.getParameter("fullname");
            int phoneNumber = Integer.parseInt(request.getParameter("phonenumber"));
            String emailaddress = (String) request.getParameter("emailaddress");
            Date dob= Date.valueOf(request.getParameter("date_of_birth"));
            int idnumber = Integer.parseInt(request.getParameter("idnumber"));
            String gender= request.getParameter("gender");
            String county = request.getParameter("county");


            Contact contact = new Contact();
            contact.setId(Integer.parseInt(request.getParameter("id")));
            contact.setFullName(fullName);
            contact.setPhoneNumber(phoneNumber);
            contact.setEmailAddress(emailaddress);
            contact.setIdNumber(idnumber);
            contact.setGender(gender);
            contact.setCounty(county);
            contact.setDOB(dob);
            System.out.println("servlet created update dao");
            contactservice.updateContact(contact);
            System.out.println("contactupdateservlet dopost");
            response.sendRedirect("/welcome");
        } catch (NumberFormatException e) {
            System.out.println("contactupdateservlet dopost numer excemption");

            doGet(request,response);
        } catch (SQLException e) {
            System.out.println("failed to update ");


        }

    }
}
