package OriginalOne;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contacts> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contacts>();
    }

    /**finding the position of the contact in the array using his name
     * @param contactName the name of the contact we are going to found
     * @return i, the position in the arraylist if the contact exist
     * @return -1, if the contact doesn't exist in the arraylist*/
    private int findContact(String contactName) {
        /*getting the position of the contact name in the arrayList*/
        for (int i = 0; i<myContacts.size(); i++) {
            /*Add every contact in the array to the contact object*/
            Contacts contact = myContacts.get(i);
            if (contact.getName().equals(contactName)){
                return i;
            }
        }
        return -1;
    }

    /**finding the position of the contact in the arrayList
     * @param contact contact we are going to found
     * @return position of the contact in the arrayList*/
    private int findContact(Contacts contact) {
        return this.myContacts.indexOf(contact);
    }

    /** Method to add new contact in the arrayList.
     *Using findContact method to control if the contact already exist.
     * @param contact The contact we are adding
     * @return true if the contact doesn't exist
     * @return false if the contact exist*/
    public boolean addNewContact(Contacts contact) {
        if (findContact(contact.getName()) >= 0) {
            System.out.println("Contact already exsist.");
            return false;
        }
        /*else*/
        myContacts.add(contact);
        return true;
    }

    /**Updating a contact
     * @param oldOne the contact we are updating
     * @param newOne the contact that replace the old one
     * @return false if the contact doesn't exist in the arraylist
     * @return true after updating the contact*/
    public boolean updateContact(Contacts oldOne, Contacts newOne) {

        int foundPosition = findContact(oldOne.getName());
        if (foundPosition < 0) {
            System.out.println(oldOne.getName() + " doesn't exist.");
            return false;
        } else if (findContact(newOne.getName()) != -1) {
            System.out.println("Contact " + newOne.getName() + " already exist.");
            return false;
        }
        /*else*/
        myContacts.set(foundPosition,newOne);
        System.out.println(oldOne.getName() + " was replaced with " + newOne.getName());
        return true;
    }

    /** Control if a contact exist in the arrayList using Contact variable
     * @param contact the contact we are going to get his position in array
     * @return contact.getName() return the name of the contact if exist.*/
    public String queryContact(Contacts contact) {
        if (findContact(contact) >= 0) {
            return contact.getName();
        }
        return null;
    }

    /** Control if a contact exist in the arrayList using Contact variable
     * @param name the name of contact we are going to get his position in array.
     * @return return the contact from the position we found in the arrayList.*/
    public Contacts queryContact(String name) {
        int position = findContact(name);
        if (position >= 0) {
            return this.myContacts.get(position);
        }
        return null;
    }

    /** Removing a contact from the arrayList
     * @param contact the contact we r going to remove
     * @return false if the contact doesn't exist in the list
     * @return true if the contact exist.*/
    public boolean removeContact (Contacts contact) {
        /*getting the position of the contact*/
        int foundPosition = findContact(contact);
        /*if it doesn't exist*/
        if (foundPosition < 0) {
            System.out.println(contact.getName() + " doesn't exist.");
            return false;
        }
        /*if the contact exist:*/
        /*remove the contact by his position*/
        this.myContacts.remove(foundPosition);
        System.out.println(contact.getName() + " was deleted.");
        return true;
    }

    /** Printing the contacts list*/
    public void printContacts() {
        System.out.println("Contact List:");
        for (int i = 0; i< this.myContacts.size(); i++) {
            System.out.println((i+1) +"." +
                                this.myContacts.get(i).getName() + "->" +
                                this.myContacts.get(i).getNumber());
        }
    }
}
