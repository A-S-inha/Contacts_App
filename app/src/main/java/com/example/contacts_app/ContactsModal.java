package com.example.contacts_app;

public class ContactsModal {

    // variables for our user name
    // and contact number.
    private String userName;
    private String contactNumber;
    private String uid;

    // constructor
    public ContactsModal(String userName, String contactNumber,String uid) {
        this.userName = userName;
        this.contactNumber = contactNumber;
        this.uid=uid;
    }

    // on below line we have
    // created getter and setter
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getUid()
    {
        return uid;
    }



}