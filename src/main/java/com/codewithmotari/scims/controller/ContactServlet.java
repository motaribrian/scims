/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.codewithmotari.scims.controller;

import com.codewithmotari.scims.model.Contact;
import com.codewithmotari.scims.service.ContactService;
import com.codewithmotari.scims.util.Factory;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Path;

/**
 *
 * @author ztl
 */
@WebServlet("/contacts")
public class ContactServlet extends HttpServlet {
    private final ContactService contactService;

    public ContactServlet() throws SQLException {
        this.contactService = Factory.getContactServiceimpl();
    }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Path("/all")
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        String jsonString="";
        Gson gson=Factory.getGson();
        try {
            //serialize contact to json
            jsonString=gson.toJson(contactService.getAllContacts());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        PrintWriter pw=response.getWriter();
        pw.print(jsonString);


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
        String contentype=request.getContentType();
        if(!"application/json".equals(contentype)){
            response.sendError(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE,"invalid content type");
            return;
        }
        try(BufferedReader reader=request.getReader()){
            Gson gson=new Gson();
            Contact contact=gson.fromJson(reader, Contact.class);
            response.getWriter()
                    .append("successfully added contact")
                    .append("<h1>")
                    .append(contact
                            .getFullName())
                    .append("</h1>");
        } catch (IOException e){
            request.setAttribute("message","There was an error :" + e.getMessage());
        }
    }



}
