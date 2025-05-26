/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.codewithmotari.scims.controller;

import com.codewithmotari.scims.model.Contact;
import com.codewithmotari.scims.service.ContactService;
import com.codewithmotari.scims.service.UserService;
import com.codewithmotari.scims.util.Factory;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;

/**
 *
 * @author ztl
 */
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10,      // 10 MB
        maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class ContactAddServlet extends HttpServlet {
    private ContactService contactService;
    private UserService userService;
    public ContactAddServlet() throws SQLException {
        contactService= Factory.getContactServiceimpl();
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
            return;
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
           // System.out.println("ContactAddservlet.dopost :" + " username is null" +username.toString());
            RequestDispatcher rd = request.getRequestDispatcher("/");
            rd.forward(request, response);
        }
        int userId;
        try {
            userId = userService.getUser((String) username).getId();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

//        String basepath="/idphotos/"+username+"/"+request.getParameter("firstname");
//        File file=new File(basepath, (String) username);
//        if(!file.exists()){
//            file.mkdirs();
//        }
//        for(Part part:request.getParts()){
//            part.write(filename);
//        }


        String firstname = request.getParameter("firstname");

// Define base directory (should be an absolute path in production)
        String basePath = System.getProperty("user.home");  // Example: "/var/www/myapp/idphotos"

        File uploadDir = new File(basePath, (String) username);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();  // Create user folder
        }

// Now define actual file path (you can use original filename or generate one)
        String fileName = firstname + ".jpg";  // You might want to sanitize or get original filename
        File outputFile = new File(uploadDir, fileName);
        System.out.println(outputFile.getAbsolutePath()+"yoooh");

        for (Part part : request.getParts()) {

            part.write(outputFile.getAbsolutePath());  // <- This is the correct file path
        }


        try {
            String fullName = request.getParameter("firstname");
            Long phoneNumber = Long.valueOf(request.getParameter("full_phone").substring(1));
            Date dateofBirth= Date.valueOf(request.getParameter("date_of_birth"));
            int idnumber = Integer.parseInt(request.getParameter("idnumber"));
            String gender=request.getParameter("gender");
            String emailaddress = request.getParameter("emailaddress");
            String county = request.getParameter("county");
            Contact contact = new Contact();
            contact.setFullName(fullName);
            contact.setPhoneNumber(phoneNumber);
            contact.setEmailAddress(emailaddress);
            contact.setIdNumber(idnumber);
            contact.setGender(gender);
            contact.setCounty(county);
            contact.setUserId(userId);
            contact.setDOB(dateofBirth);
            contact.setFilepath(outputFile.getAbsolutePath());
            contactService.createContact(contact);

            response.sendRedirect("/welcome");

//            RequestDispatcher rd = request.getRequestDispatcher("/welcome");
//            rd.forward(request, response);

        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            doGet(request,response);
        }


    }




}
