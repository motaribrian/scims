/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.codewithmotari.scims;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ztl
 */
public class ContactAddServlet extends HttpServlet {
    private ContactService contactService;
    private UserService userService;
    public ContactAddServlet() throws SQLException {
        contactService=Factory.getContactServiceimpl();
        userService=Factory.getUserService();
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session=request.getSession();
        Object username=  session.getAttribute("username");

        if(username==null){
            RequestDispatcher rd= request.getRequestDispatcher("/");
            rd.forward(request,response);
        }
        RequestDispatcher view= request.getRequestDispatcher("/contactAdd.jsp");
        view.forward(request,response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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
            System.out.println(emailaddress);
            System.out.println(idnumber);

            //Contact.Gender gender= (Contact.Gender) request.getParameter("gender");
            String county = (String) request.getParameter("county");
            System.out.println(county);


            Contact contact = new Contact();
            contact.setFullName(fullName);
            contact.setPhoneNumber(phoneNumber);
            contact.setEmailAddress(emailaddress);
            contact.setIdNumber(idnumber);
            //contact.setGender(gender);
            contact.setCounty(county);
            contact.setUserId(userId);
            contactService.createContact(contact);
            RequestDispatcher rd = request.getRequestDispatcher("/welcome");
            rd.forward(request, response);

        } catch (SQLException | NumberFormatException e) {
            doGet(request,response);
        }


    }




}
