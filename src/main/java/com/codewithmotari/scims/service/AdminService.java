package com.codewithmotari.scims.service;

import com.codewithmotari.scims.model.Contact;
import com.codewithmotari.scims.util.Factory;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminService {
    private ContactService contactService= Factory.getContactServiceimpl();
   Map<String,List<Contact>> usersByGender;
    Map<String,List<Contact>> usersByCounty;
    Map<String,List<Contact>> last5Contacts;
    private List<Contact> contacts;

    public AdminService() throws SQLException {
        usersByGender = new HashMap<>();
        usersByCounty = new HashMap<>();
        last5Contacts=new HashMap<>();
        contacts=Factory.getContactServiceimpl().getAllContacts();
    }

    public Map<String, List<Contact>> getUsersByGender(String[] gender) throws SQLException {
        for(String gend :gender){
            List<Contact> contactsgender=contactService.getContactByGender(gend);
            usersByGender.put(gend.toUpperCase(),contactsgender);

        }
        return usersByGender;

    }

    public void addUsersByGender(String gender) throws SQLException {
        List<Contact> contactsgender=contactService.getContactByGender(gender);
        usersByGender.put(gender.toUpperCase(),contactsgender);
    }


    public Map<String, List<Contact>> getUsersByCounty(String[] county) throws SQLException {
            //HttpResponse<String> response=Unirest.get();
        for(String count :county){
            List<Contact> contactsgender=contactService.getContactByCounty(count);
            usersByCounty.put(count.toUpperCase(),contactsgender);

        }
        return usersByCounty;

    }

    public Map<String, List<Contact>> getLastnaddedcontacts(int i) throws SQLException {
        List<Contact> lastn=contactService.getLastnContacts(i);
        last5Contacts.put("LastAdded",lastn);
        return last5Contacts;

    }
}
