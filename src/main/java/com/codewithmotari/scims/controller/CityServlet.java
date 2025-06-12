package com.codewithmotari.scims.controller;

import com.codewithmotari.scims.model.City;
import com.codewithmotari.scims.util.ExcelReader;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/cities/all/*")
public class CityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ExcelReader reader=new ExcelReader();
        List<City> cities=new ArrayList<>();
        if(req.getPathInfo().substring(1).isEmpty()){
           cities =reader.getAllCities();
        }
        else {
            cities=reader.getAllCities(req.getPathInfo().substring(1).toUpperCase());
        }
        String citiesstring=new Gson().toJson(cities);
        System.out.println(req.getPathInfo());
        resp.getWriter().print(citiesstring);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
