package com.codewithmotari.scims;

public class Contactdto {
    private int id;
    private String fullnName;
    private int phonenumber;
    private String email;

    public Contactdto(int id, String fullnName, int phonenumber, String email) {
        this.id = id;
        this.fullnName = fullnName;
        this.phonenumber = phonenumber;
        this.email = email;
    }

    public Contactdto() {
    }
}
