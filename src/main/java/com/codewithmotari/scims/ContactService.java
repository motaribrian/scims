package com.codewithmotari.scims;

import java.sql.SQLException;
import java.util.List;

public interface ContactService {
    public List<Contact> getAllContacts() throws SQLException;
    public Contact getContact(int id)throws SQLException;
}
