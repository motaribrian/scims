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
        HttpSession session = request.getSession();
        Object username = session.getAttribute("username");

        if (username == null) {
            RequestDispatcher rd = request.getRequestDispatcher("/");
            rd.forward(request, response);
        }
        int userId;
        try {
            userId = userService.getUser((String) username).getId();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



        try {
            String firstName = request.getParameter("firstname");
            String lastName = (String) request.getParameter("lastname");
            String fullName = firstName + " " + lastName;
            int phoneNumber = Integer.parseInt(request.getParameter("phonenumber"));
            int idnumber = Integer.parseInt(request.getParameter("idnumber"));

            String emailaddress = (String) request.getParameter("emailaddress");
            System.out.println(idnumber);

            String gender= request.getParameter("gender");
            String county = request.getParameter("county");
            System.out.println(county);
            Date dob= Date.valueOf(request.getParameter("date_of_birth"));


            Contact contact = new Contact();
            contact.setId(userId);
            contact.setFullName(fullName);
            contact.setPhoneNumber(phoneNumber);
            contact.setEmailAddress(emailaddress);
            contact.setIdNumber(idnumber);
            contact.setGender(gender);
            contact.setCounty(county);
            contact.setUserId(userId);
            contact.setDOB(dob);
            contactservice.updateContact(contact);
            response.sendRedirect("/welcome");
        } catch (NumberFormatException e) {
            doGet(request,response);
        } catch (SQLException e) {
            System.out.println("failed to update ");
            throw new RuntimeException(e);
        }

    }
}
