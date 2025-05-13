/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codewithmotari.scims;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ztl
 */
public class ContactDAO {
    private final Connection con;

    public ContactDAO() throws SQLException {
        this.con = DBConnection.getConnection();
    }
    
    public Contact createContact(Contact contact){return null;}



    public List<Contact> getAllContacts() throws SQLException{
        List<Contact> allcontacts=new ArrayList<>();
        String query="select * from contacts";
        Statement stmt=con.createStatement();
        ResultSet rs= stmt.executeQuery(query);
        while (rs.next()){
            Contact c=new Contact();
            c.setPhoneNumber(Integer.parseInt(rs.getString("phoneNumer")));
            c.setEmailAddress(rs.getString("emailAddress"));
            c.setId(Integer.parseInt(rs.getString("idNumber")));
            c.setDOB(rs.getDate("DOB"));
            c.setGender(rs.getObject("gender", Contact.Gender.class));
            c.setCounty(rs.getString("county"));

            //add the contact to the list
            allcontacts.add(c);
        }
        
        
        return allcontacts;}
    public Contact getContact(int id) throws SQLException {
        Contact contact=new Contact();
        String query="select * from contacts where id=id";
        PreparedStatement ps=con.prepareStatement(query);
        ResultSet rs=ps.executeQuery();
        if (rs.next()){
            contact.setFullName(rs.getString("full_name"));
            contact.setPhoneNumber(Integer.parseInt(rs.getString("phone_number")));
            contact.setEmailAddress(rs.getString("email_address"));
            contact.setDOB(rs.getDate("date_of_birth"));
            contact.setGender(rs.getObject("gender", Contact.Gender.class));
            contact.setCounty(rs.getString("county"));
        }

        return contact;}
    public Contact getContact(String email){

        return null;}
    public boolean updateContact(Contact contact){return false;}
    public void deleteContact(Contact contact){}
    
}
