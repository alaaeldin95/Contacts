package OriginalOne;

import java.util.Scanner;

public class Main {
    private static Scanner input = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("3922149443");

    /*MAIN*/
    public static void main(String[] args) {

        boolean quit = false;
        startPhone();
        printActions();

        while (!quit) {
            System.out.println("\nEnter action: (6 to show avaiable action)");
            int action = input.nextInt();
            input.nextLine();

            switch (action) {
                case 0:
                    System.out.println("\nShutting down...");
                    quit = true;
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addNewContact();
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
                case 6:
                    printActions();
                    break;
            }
        }

     }

     private static void addNewContact() {
         System.out.println("Enter new contact name: ");
         String name = input.nextLine();
         System.out.println("Enter phone number: ");
         String phone = input.nextLine();
         Contacts newContact = Contacts.createContact(name, phone);
         if (mobilePhone.addNewContact(newContact)) {
             System.out.println("New Contact added: name " + name + ", phone = " + phone);
         }
         else {
             System.out.println("Cannot add, " + name + " already on file");
         }
     }

     private static void updateContact() {
         System.out.println("Enter existing contact: ");
         String name = input.nextLine();
//         mobilePhone.queryContact(name);
         Contacts existingContactRecord = mobilePhone.queryContact(name);
         if (existingContactRecord == null) {
             System.out.println("Contact not found.");
             return;
         }

         /* if the contact exist:*/
         System.out.println("Enter new contact name: ");
         String newName = input.nextLine();
         System.out.println("Enter new contact phone number: ");
         String newNumber = input.nextLine();

         Contacts newContactControl = mobilePhone.queryContact(newName);
         if (newContactControl != null) {
             System.out.println("Use another name, contact name already exist");
             return;
         }

         Contacts newContact = Contacts.createContact(newName, newNumber);
         if (mobilePhone.updateContact(existingContactRecord, newContact)) {
             System.out.println("Successfully updated record.");
         } else {
             System.out.println("Error updating recording.");
         }
     }

     private static void removeContact() {
         System.out.println("Enter existing contact: ");
         String name = input.nextLine();
         mobilePhone.queryContact(name);
         Contacts existingContactRecord = mobilePhone.queryContact(name);
         if (existingContactRecord == null) {
             System.out.println("Contact not found.");
             return;
         }

         if(mobilePhone.removeContact(existingContactRecord)) {
             System.out.println("Successfully deleted.");
         } else {
                     System.out.println("Error deleting contact.");
         }
     }

    private static void queryContact() {
        System.out.println("Enter existing contact: ");
        String name = input.nextLine();
        mobilePhone.queryContact(name);
        Contacts existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found.");
            return;
        }
        System.out.println("Name: " + existingContactRecord.getName() + ", phone number: " + existingContactRecord.getNumber());
    }

     private static void startPhone() {
         System.out.println("Starting phone..");
     }

     private static void printActions() {
         System.out.println("\n Avaiable actions: \npress");
         System.out.println("0 - to shutdown\n" +
                            "1 - to print contacts\n" +
                            "2 - to add a new contact\n" +
                            "3 - to update an existing contact\n" +
                            "4 - to remove an existing contact\n" +
                            "5 - query if an existing contact exist\n" +
                            "6 - to print a list of avaiable actions.");
         System.out.println("choose your action: ");
     }
}
