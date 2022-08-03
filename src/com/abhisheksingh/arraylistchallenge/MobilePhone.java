package com.abhisheksingh.arraylistchallenge;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {
    private String myNumber;
    private List<Contacts> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contacts>();
    }

    public boolean addNewContact (Contacts contacts){
        if (findContact(contacts.getName()>=0)) {
            System.out.println("Contact is already on file");
        }
        myContacts.add(contacts);
        return true;
    }

    private int findContact(Contacts contacts) {
        return this.myContacts.indexOf(contacts);
    }


    private int findContact ( String contactName) {
        for (int i = 0; i < this.myContacts.size(); i++) {
        Contacts contacts = this.myContacts.get(i);
        if (contacts.getName().equals(contactName)){
            return i;
        }

        }
        return -1;
    }
    public boolean updateContact (Contacts oldContact , Contacts newContact ){
        int foundPosition = findContact(oldContact);
        if(foundPosition<0){
            System.out.println(oldContact.getName() + " , was not found");
            return false;
        }
        this.myContacts.set(foundPosition,newContact);
        System.out.println(oldContact.getName() + " , was replaced with " + newContact.getName());
        return true;
    }

    public String queryContact (Contacts contacts) {
        if (findContact(contacts) >=0){
            return contacts.getName();
        }
        return null;
    }
public boolean removeContact (Contacts contacts){
    int foundPosition = findContact(contacts);
    if(foundPosition<0){
        System.out.println(contacts.getName() + " , was not found");
        return false;
    }
    this.myContacts.remove(foundPosition);
    System.out.println(contacts.getName()+ " ,was deleted ");
    return true;
}
}
