package com.codewithmotari.scims.service;

import com.codewithmotari.scims.model.Contact;
import com.codewithmotari.scims.repository.ContactDAO;
import com.codewithmotari.scims.util.Factory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactServiceimpl implements ContactService {
    private ContactDAO contactdao;

    public ContactServiceimpl() throws SQLException {
        contactdao = Factory.getContactdao();
    }



    @Override
    public List<Contact> getAllContacts() throws SQLException {
        return contactdao.getAllContacts();
    }


    public List<Contact> filterByGenderAndCounty(List<Contact> list,String gender,String county){
        List<Contact> contacts=new ArrayList<>();
        if(gender.isEmpty() && county.isEmpty()){
            return list;
        }

        else if (gender.isEmpty()) {
                for (Contact contact2 : list) {
                    if(contact2.getCounty().equalsIgnoreCase(county)){
                        contacts.add(contact2);
                    }
            }
            return contacts;
        }

        else if (county.isEmpty()) {
            for (Contact contact : list) {
                if (contact.getGender().equalsIgnoreCase(gender)) {
                    contacts.add(contact);
                }
            }
            return contacts;
        }

        else {
            for (Contact contact : list) {
                if (!(contact.getGender().equalsIgnoreCase(gender) && contact.getCounty().equalsIgnoreCase(county))) {
                    contacts.add(contact);
                }

            }
            return list;
        }
    }

    @Override
    public Contact getContact(int id) throws SQLException {
        return contactdao.getContact(id);
    }

    @Override
    public boolean createContact(Contact contact) throws SQLException {
        Contact c=contactdao.createContact(contact);
        return c != null;
    }

    @Override
    public List<Contact> getContactbyUser(int userId) throws SQLException {
        return contactdao.getContactbyUser(userId);
    }

    @Override
    public void updateContact(Contact contact) throws SQLException {
        System.out.println("contac6tserviceimpl updateContact");
        contactdao.updateContact(contact);
    }

    @Override
    public void deleteUser(int id) throws SQLException {

        contactdao.deleteContact(id);
    }

    @Override
    public List<Contact> getContactByGender(String gender) throws SQLException {
        return contactdao.getContactsByGender(gender);
    }

    @Override
    public List<Contact> getContactByCounty(String count) throws SQLException {
        return contactdao.getContactByCounty(count);
    }

    @Override
    public List<Contact> getLastnContacts(int i) throws SQLException {
        return contactdao.getLastNContacts(i);
    }

    @Override
    public List<Contact> getByCountyorGender(String gender) throws SQLException {
        
        return null;
    }
}
