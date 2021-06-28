import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

import models.Contact;
import models.ContactManager;

public class Main {
    static ContactManager manager = new ContactManager();
    
    public static void main(String[] args) {
        try {
            loadContacts("contacts.txt");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("CONTACTS LOADED");
            System.out.println(manager);
            manageContacts();
        }
        
    }

    public static void manageContacts() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Kindly choose \n\ta. add a contact \n\tb. remove a contact \n\tc. exit");
            String userChoice = scan.nextLine();
            switch (userChoice) {
                case "a":
                    System.out.print("\tName: ");
                    String name = scan.nextLine();
                    System.out.print("\tPhone Number: ");
                    String phoneNumber = scan.nextLine();
                    System.out.print("\tBirth Date (MM/dd/yyyy): ");
                    String dob = scan.nextLine();
                    try {
                        manager.addContact(new Contact(name, dob, phoneNumber));
                        continue;
                    } catch (ParseException e) {
                        System.out.println(e.getMessage());
                    } finally {
                        System.out.println( "\n\nUPDATED CONTACTS\n\n" + manager);
                    }
                case "b":
                    System.out.println("\nWho would you like to remove?");
                    String nameToRemove = scan.nextLine();
                    manager.removeContact(nameToRemove);
                    System.out.println(manager);
                    continue;
                case "c":
                    break;
            }
        scan.close();
        }
        
    }
    public static void loadContacts(String fileName) throws FileNotFoundException{
        FileInputStream fis = new FileInputStream(fileName);
        Scanner scan = new Scanner(fis);
        while (scan.hasNextLine()) {
            try {
                Contact contact = new Contact(scan.next(), scan.next(), scan.next());
                manager.addContact(contact);
            } catch (ParseException e) {
                System.out.println(e.getMessage());
            }
           
        }
        scan.close();
    }

}
