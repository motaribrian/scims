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
    //returns a one or 0
    public Contact createContact(Contact contactdto) throws SQLException {
//        String query="insert into contacts (full_names,phone_number,id_number,date_of_brith,gender,county) values ('"+contactdto.getFullName()+","+contactdto.getPhoneNumber()+","+contactdto.getIdNumber()+","+contactdto.getDOB()+","+contactdto.getGender()+","+contactdto.getCounty()+
//                "')";







        String query = "INSERT INTO contacts (full_names, phone_number, id_number , date_of_brith, county , user_id ,email_address) values (?,?,?,?,?,?,?)";
        PreparedStatement stmt= con.prepareStatement(query);
        stmt.setString(1,contactdto.getFullName());
        stmt.setInt(2,contactdto.getPhoneNumber());
        stmt.setInt(3,contactdto.getIdNumber());
        stmt.setInt(6,contactdto.getUserId());
        stmt.setDate(4,contactdto.getDOB());
        stmt.setString(5, contactdto.getCounty());
        stmt.setString(7,contactdto.getEmailAddress());
        int created=stmt.executeUpdate();
        stmt.close();
        if (created==0){
            return null;
        }
        return contactdto;
    }


    //implemented to fetch all contacts from db
    public List<Contact> getAllContacts() throws SQLException{
        List<Contact> allcontacts=new ArrayList<>();
        String query="select * from contacts";
        Statement stmt=con.createStatement();
        ResultSet rs= stmt.executeQuery(query);
        while (rs.next()){
            Contact c=new Contact();
            c.setFullName(rs.getString("full_names"));
            c.setPhoneNumber(Integer.parseInt(rs.getString("phone_number")));
            c.setEmailAddress(rs.getString("email_address"));
            c.setId(rs.getInt("id"));
            try{
           c.setDOB(rs.getDate("date_of_brith"));} catch (SQLException e) {
                c.setDOB(null);
                throw new RuntimeException(e);
            }
            c.setGender(rs.getString("gender"));
            c.setCounty(rs.getString("county"));

            //add the contact to the list
            allcontacts.add(c);
        }
        
        
        return allcontacts;}

    public Contact getContact(int id) throws SQLException {
        Contact contact=new Contact();
        String query="select * from contacts where id="+id;
        PreparedStatement ps=con.prepareStatement(query);
        ResultSet rs=ps.executeQuery();
        if (rs.next()){
            contact.setFullName(rs.getString("full_name"));
            contact.setPhoneNumber(Integer.parseInt(rs.getString("phone_number")));
            contact.setEmailAddress(rs.getString("email_address"));
            contact.setDOB(rs.getDate("date_of_birth"));
            contact.setGender(rs.getString("gender"));
            contact.setCounty(rs.getString("county"));
        }

        return contact;}

    //get a contact if an email is provided
    public Contact getContact(String email) throws SQLException {
        Contact contact=new Contact();
        String query="select * FROM contacts WHERE email_address="+email;
        PreparedStatement ps=con.prepareStatement(query);
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
            contact.setFullName(rs.getString("full_name"));
            contact.setPhoneNumber(Integer.parseInt(rs.getString("phone_number")));
            contact.setEmailAddress(rs.getString("email_address"));
            contact.setDOB(rs.getDate("date_of_birth"));
            contact.setGender(rs.getString("gender"));
            contact.setCounty(rs.getString("county"));
            return contact;
        }
        return null;
    }


    //get a contact if an email is provided
    public List<Contact> getContactbyUser(int  userId) throws SQLException {
        List<Contact> list=new ArrayList<>();
        String query="select * FROM contacts WHERE user_id="+userId;
        PreparedStatement ps=con.prepareStatement(query);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            Contact contact=new Contact();
            contact.setFullName(rs.getString("full_names"));
            contact.setPhoneNumber(Integer.parseInt(rs.getString("phone_number")));
            contact.setEmailAddress(rs.getString("email_address"));
            contact.setDOB(rs.getDate("date_of_brith"));
            contact.setGender(rs.getString("gender"));
            contact.setCounty(rs.getString("county"));
             list.add(contact);
        }
        System.out.println("returned from contactDao.getContactByUser () :" +list);
        return list;
    }


    public boolean updateContact(Contact contact){return false;}
    public void deleteContact(Contact contact){}
    
}
