package com.codewithmotari.scims;

import java.sql.SQLException;
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

    @Override
    public Contact getContact(int id) throws SQLException {
        return contactdao.getContact(id);
    }

    @Override
    public boolean createContact(Contact contact) throws SQLException {
        Contact c=contactdao.createContact(contact);
        return c != null;
    }
}
