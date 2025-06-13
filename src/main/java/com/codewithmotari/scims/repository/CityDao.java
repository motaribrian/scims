package com.codewithmotari.scims.repository;

import com.codewithmotari.scims.model.City;
import com.codewithmotari.scims.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CityDao {
    private CityDaoex cityDaoex;
    private Connection con;

    public CityDao() throws SQLException {
        this.cityDaoex=new CityDaoex();
        this.con= DBConnection.getConnection();
    }
    public void initDB() throws SQLException {
        List<City> allcities=cityDaoex.getAllCities();

        String query="insert into cities (city_name,city_latitude,city_longitude,city_country,city_country_iso2,city_country_iso3) values(?,?,?,?,?,?)";
        Iterator<City> it=allcities.iterator();
        PreparedStatement stmt=con.prepareStatement(query);
        while (it.hasNext()){
            City city=it.next();
            stmt.setString(1,city.getCityName());
            stmt.setLong(2, (long) city.getLatitude());
            stmt.setDouble(3,city.getLongitude());
            stmt.setString(4,city.getCountryName());
            stmt.setString(5,city.getCountryIso2());
            stmt.setString(6,city.getCountryIso3());

            stmt.execute();
        }
        System.out.println("succesfully created");

    }
    public List<String> getAllCountries() throws SQLException {
        List<String> countries=new ArrayList<>();
        String query="select DISTINCT city_country from cities";
        PreparedStatement stmt=con.prepareStatement(query);
        ResultSet rs=stmt.executeQuery();
        while (rs.next()){
            countries.add(rs.getString("city_country"));
        }
        return countries;
    }

    public List<City> getAllCities() throws SQLException {
        List<City> cities=new ArrayList<>();
        String query="select * from cities";
        PreparedStatement stmt=con.prepareStatement(query);
        ResultSet rs=stmt.executeQuery();
        while (rs.next()){
            City city=new City();
            city.setCityId(rs.getInt("city_id"));
            city.setCityName(rs.getString("city_name"));
            city.setLatitude(rs.getLong("city_latitude"));
            city.setLongitude(rs.getLong("city_longitude"));
            city.setCountryName(rs.getString("city_country"));
            city.setCountryIso2(rs.getString("city_country_iso2"));
            city.setCountryIso3(rs.getString("city_country_iso3"));
            cities.add(city);
        }
        return cities;
    }
}
