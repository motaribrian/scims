package com.codewithmotari.scims.controller;

import com.codewithmotari.scims.model.City;
import com.codewithmotari.scims.repository.CityDao;
import com.codewithmotari.scims.repository.CityDaoex;
import com.codewithmotari.scims.service.CityService;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/cities/*")
public class CityServlet extends HttpServlet {
    private final CityService cityService=new CityService();

    public CityServlet() throws SQLException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CityDaoex reader=new CityDaoex();
        System.out.println(req.getPathInfo());
        List<City> cities=new ArrayList<>();
        if(req.getPathInfo().substring(1).isEmpty()  || req.getPathInfo().substring(1).equals("all")){

            try {
                cities =cityService.getAllCities();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            cities=reader.getAllCitiesByIso2(req.getPathInfo().substring(1).toUpperCase());
        }
        String citiesstring=new Gson().toJson(cities);
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
