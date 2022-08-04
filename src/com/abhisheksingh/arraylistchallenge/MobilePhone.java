package com.abhisheksingh.arraylistchallenge;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {

    private final List<Contacts> myContacts;

    public MobilePhone() {
        this.myContacts = new ArrayList<>();
    }

    public boolean addNewContact (Contacts contacts){
        if (findContact(contacts.getName())>=0) {
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
    public void printContacts (){
        System.out.println("Contact List");
        for (int i = 0; i < this.myContacts.size(); i++) {
            System.out.println((i+1) + "." +
                               this.myContacts.get(i).getName() + "-->" +
                               this.myContacts.get(i).getPhoneNumber());

        }
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

    public Contacts queryContact (String name) {
        int position = findContact(name);
        if (position>=0) {
            return this.myContacts.get(position);
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
