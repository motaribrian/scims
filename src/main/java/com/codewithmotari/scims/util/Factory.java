package com.codewithmotari.scims.util;

import com.codewithmotari.scims.repository.ContactDAO;
import com.codewithmotari.scims.repository.UserDao;
import com.codewithmotari.scims.service.ContactServiceimpl;
import com.codewithmotari.scims.service.JasperReportService;
import com.codewithmotari.scims.service.UserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.sql.SQLException;

public class Factory {
    private static ContactServiceimpl contactServiceimpl;
    private static ContactDAO contactDAO;
    private static UserDao userdao;
    private static UserService userservice;
    private static JasperReportService jasperreportService;


    public static JasperReportService getJasperReportService() {
        if(jasperreportService==null){
            jasperreportService=new JasperReportService();
        }
        return jasperreportService;
    }

    public static void setJasperReportService(JasperReportService jasperReportService) {
        Factory.jasperReportService = jasperReportService;
    }

    private static JasperReportService jasperReportService;

    public Factory() throws SQLException {
        contactServiceimpl = new ContactServiceimpl();
        contactDAO=new ContactDAO();

    }

    public static ContactServiceimpl getContactServiceimpl() throws SQLException {
        if(contactServiceimpl == null){
            contactServiceimpl=new ContactServiceimpl();
        }
        return contactServiceimpl;
    }

    public static ContactDAO getContactdao() throws SQLException {
        if(contactDAO==null){
            contactDAO=new ContactDAO();
        }
        return contactDAO;
    }

    public static Gson getGson() {
        //created a gson in order to help serialize a contact object to json
        Gson gson=new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson;
    }

    public static UserDao getUserDao() throws SQLException {
        if (userdao==null){
            userdao=new UserDao();
        }
        return userdao;
    }

    public static UserService getUserService() {
        if(userservice==null){userservice=new UserService();}
        return userservice;
    }
}
