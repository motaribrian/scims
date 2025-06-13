package com.codewithmotari.scims.service;

import com.codewithmotari.scims.model.City;
import com.codewithmotari.scims.repository.CityDao;

import java.sql.SQLException;
import java.util.List;

public class CityService {
    private final CityDao cityDao;

    public CityService() throws SQLException {
        this.cityDao = new CityDao();
    }

    public List<String> getAllCountries() throws SQLException {
        return cityDao.getAllCountries();
    }

    public List<City> getAllCities() throws SQLException {
        return cityDao.getAllCities();
    }
}
