package com.codewithmotari.scims.controller;

import com.codewithmotari.scims.model.Contact;
import com.codewithmotari.scims.service.ContactService;
import com.codewithmotari.scims.service.UserService;
import com.codewithmotari.scims.util.Factory;

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
        System.out.println("username is not null");
        int userId;
        try {
            userId = userService.getUser((String) username).getId();

            String fullName = (String) request.getParameter("fullname");
            Long phoneNumber = Long.valueOf(request.getParameter("full_phone").substring(1));
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
