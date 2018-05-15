import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contacts> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contacts>();
    }

    /**Founding the position of the contact in the array using his name
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

    /** Method to add new contact in the arraylist.
     *Using findContact method to control if the contact already exist.
     * @param contact The contact we are adding
     * @return true if the contact doesn't exist
     * @return false if the contact exist*/
    public boolean addNewContact(Contacts contact) {
        if (findContact(contact.getName()) >= 0) {
            System.out.println("Contact already exsist.");
            return false;
        }

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
        }

        myContacts.set(foundPosition,newOne);
        System.out.println(oldOne.getName() + " was replaced " + newOne.getName());
        return true;
    }
}
