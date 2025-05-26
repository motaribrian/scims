package com.codewithmotari.scims.service;

import com.codewithmotari.scims.model.Contact;

import java.sql.SQLException;
import java.util.List;

public interface ContactService {
    public List<Contact> getAllContacts() throws SQLException;
    public Contact getContact(int id)throws SQLException;
    public boolean createContact(Contact contact) throws SQLException;
    public List<Contact> getContactbyUser(int userId) throws SQLException;

    public void updateContact(Contact contact) throws SQLException;

    void deleteUser(int id) throws SQLException;
    List<Contact> getContactByGender(String gender) throws SQLException;

    List<Contact> getContactByCounty(String count) throws SQLException;

    List<Contact> getLastnContacts(int i) throws SQLException;
    List<Contact> getByCountyorGender(String gender) throws SQLException;
}
