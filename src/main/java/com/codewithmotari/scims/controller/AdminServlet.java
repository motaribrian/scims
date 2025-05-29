package com.codewithmotari.scims.controller;

import com.codewithmotari.scims.model.Contact;
import com.codewithmotari.scims.service.AdminService;
import com.codewithmotari.scims.util.Factory;
import com.google.gson.Gson;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object username = req.getSession().getAttribute("username");
        try {
            resp.setCharacterEncoding("UTF-8");
            Map<String,List<Contact>> lastn=new HashMap<>();
            AdminService adminservice=new AdminService();
            Gson gson=new Gson();
            Map<String, Map<String,List<Contact>>> responseMap=new HashMap<>();
            responseMap.put("Gender",adminservice.getUsersByGender(Factory.getContactdao().getDistinctGenders()));
            responseMap.put("Counties",adminservice.getUsersByCounty(Factory.getContactdao().getDistinctCounties()));
            responseMap.put("last5Added",adminservice.getLastnaddedcontacts(5));
            //resp.getWriter().write(gson.toJson(responseMap));

            req.setAttribute("admindto",responseMap);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//        will uncomment later for now lets just parse json
        RequestDispatcher view=req.getRequestDispatcher("/admin.jsp");
        view.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
