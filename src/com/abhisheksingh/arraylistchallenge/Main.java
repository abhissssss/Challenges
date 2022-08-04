package com.abhisheksingh.arraylistchallenge;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final MobilePhone mobilePhone = new MobilePhone();

    public static void main(String[] args) {
        boolean quit = false;
        startPhone();
        printActions();
        while (!quit) {
            System.out.println("\nEnter action:(6 to show available actions) ");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("\nShutting down....");
                    quit = true;
                    break;
                case 1:
                    mobilePhone.printContacts();
                case 2:
                    addNewContacts();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6 :
                    printActions();
                    break;

            }
        }
    }

    private static void startPhone() {
        System.out.println("Starting phone.....");
    }

    private static void printActions() {
        System.out.println("\n Available actions: \n press");
        System.out.println("""
                0 - to shutdown
                1 - to print contacts\s
                2 - to add new contact\s
                3 - to update an existing contact\s
                 4 - to remove an existing contact\s
                5 - query if an existing contact exists\s
                6 - to print a list of available actions\s
                """);
        System.out.println("Choose your action: ");
    }


    private static void addNewContacts() {
        System.out.println("Enter new Contact Name :");
        String name = scanner.nextLine();
        System.out.println("Enter new Phone Number : ");
        String number = scanner.nextLine();
        Contacts newContact = Contacts.createContact(name, number);
        if (mobilePhone.addNewContact(newContact)) {
            System.out.println("New contact added successfully " + name + "Phone number : " + number);
        } else {
            System.out.println("Contact already on file");
        }
    }

    private static void updateContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contacts existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found .");
            return;
        }
        System.out.println("Enter new contact name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter new contact number: ");
        String newNumber = scanner.nextLine();
        Contacts newContact = Contacts.createContact(newName, newNumber);
        if (mobilePhone.updateContact(existingContactRecord, newContact)) {
            System.out.println("Successfully updated record");
        } else {
            System.out.println("Error updating record ");
        }
    }

    private static void removeContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contacts existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found .");
            return;
        }
        if(mobilePhone.removeContact(existingContactRecord)){
            System.out.println("Deleted Successfully");
        }
        else {
            System.out.println("Error deleting record");
        }
    }

    private static void queryContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contacts existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found .");
            return;
        }
        System.out.println("Name: " +existingContactRecord.getName() + " phone number is " + existingContactRecord.getPhoneNumber());
    }
}

