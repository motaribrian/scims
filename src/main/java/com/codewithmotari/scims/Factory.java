package com.codewithmotari.scims;

import java.sql.SQLException;

public class Factory {
    private static ContactServiceimpl contactServiceimpl;
    private static ContactDAO contactDAO;

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
}
