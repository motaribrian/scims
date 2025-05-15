/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codewithmotari.scims;

import java.sql.Date;

/**
 *
 * @author ztl
 */
public class Contact {
    
    private int  id;
    private String fullName;
    private int phoneNumber;
    private String emailAddress;
    private int idNumber;
    private Date DOB;
    private String gender;
    private String County;
    private int userId;

    public enum Gender {
        MALE,
        FEMALE,
        NONBINARY;

        @Override
        public String toString() {
            return "Gender{}";
        }
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", emailAddress='" + emailAddress + '\'' +
                ", idNumber=" + idNumber +
                ", DOB=" + DOB +
                ", gender=" + gender +
                ", County='" + County + '\'' +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Contact(int id, String fullName, int phoneNumber, String emailAddress, int idNumber, Date DOB, String gender, String county, int userId) {
        this.id = id;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.idNumber = idNumber;
        this.DOB = DOB;
        this.gender = gender;
        County = county;
        this.userId = userId;
    }

    public Contact() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCounty() {
        return County;
    }

    public void setCounty(String County) {
        this.County = County;
    }
    
    
    
}
