package models;

import java.util.ArrayList;

public class ContactManager {
    ArrayList <Contact> contacts;

    public ContactManager() {
        this.contacts = new ArrayList<Contact>();
    }

    public Contact getContacts(int index) {
        return new Contact(contacts.get(index));
    }

    public void setContact(Contact contact, int index) {
        contacts.set(index, new Contact(contact));
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void removeContact(String contactName) {
        if (contacts.isEmpty()) {
            throw new IllegalArgumentException("There is no contact to remove from");
        } else {
            for (int i = 0; i < contacts.size(); i++) {
                if (contacts.get(i).getName().equals(contactName)) {
                        contacts.remove(i);
                }
            }
        }
        
    }
    public String toString() {
        String temp = " ";
        for (int i = 0; i < contacts.size(); i++) {
            temp += contacts.get(i).toString();
            temp += "\n\n";
        }
        return temp;
    }
}
