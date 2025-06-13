package com.codewithmotari.scims.repository;

import com.codewithmotari.scims.model.City;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CityDaoex {
    String filePath = "worldcities.xlsx";
    Sheet sheet;
    public CityDaoex() {
        try (InputStream fis = getClass().getResourceAsStream("/" + filePath)) {
            assert fis != null;
            try (Workbook workbook = new XSSFWorkbook(fis)) {
                sheet = workbook.getSheetAt(0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<City> getAllCitiesByIso2(String iso2) {
        List<City> cities =new ArrayList<>();
        for (Row row : sheet) {
            City city = null;
            if (row.getRowNum() > 0 && row.getCell(5).getStringCellValue().equals(iso2)) {
                city = new City();
                for (Cell cell : row) {
                    switch (cell.getColumnIndex()) {
                        case 0:
                            city.setCityName(cell.getStringCellValue());
                            break;
                        case 2:
                            city.setLatitude(cell.getNumericCellValue());
                            break;
                        case 3:
                            city.setLongitude(cell.getNumericCellValue());
                            break;
                        case 4:
                            city.setCountryName(cell.getStringCellValue());
                            break;
                        case 5:
                            city.setCountryIso2(cell.getStringCellValue());
                            break;
                        case 6:
                            city.setCountryIso3(cell.getStringCellValue());
                            break;
                        default:
                            break;
                    }
                }
            }if(city!=null){
            cities.add(city);}
        }
        return cities;
    }


    public List<City> getAllCities() {
            List<City> cities =new ArrayList<>();
            for (Row row : sheet) {
                if (row.getRowNum() > 0) {
                    City city = null;
                    city = new City();
                    for (Cell cell : row) {
                        switch (cell.getColumnIndex()) {
                            case 0:
                                city.setCityName(cell.getStringCellValue());
                                break;
                            case 2:
                                city.setLatitude(cell.getNumericCellValue());
                                break;
                            case 3:
                                city.setLongitude(cell.getNumericCellValue());
                                break;
                            case 4:
                                city.setCountryName(cell.getStringCellValue());
                                break;
                            case 5:
                                city.setCountryIso2(cell.getStringCellValue());
                                break;
                            case 6:
                                city.setCountryIso3(cell.getStringCellValue());
                                break;
                            default:
                                break;
                        }
                    }
                    cities.add(city);
                }

            }
            return cities;
        }

    }
