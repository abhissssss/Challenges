package com.abhisheksingh.arraylistchallenge;

public class Contacts {
    private final String name;
    private final String phoneNumber;

    public Contacts(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        
        return phoneNumber;
    }

    public static Contacts createContact(String name, String phoneNumber) {
        return new Contacts(name, phoneNumber);
    } //factory method
}
