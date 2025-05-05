import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ContactManagerApp {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        // instance of ContactManager
        ContactManager manager  = new ContactManager();
        
        while (true) {
            // User menu
            System.out.println("\n===== Contact List Menu ====");
            System.out.println("1) Add Contact");
            System.out.println("2) List Contact");
            System.out.println("3) Search Contact by Name");
            System.out.println("4) Exit");
            System.out.println("Enter your choice");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    //Adding a new contact
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter phone: ");
                    String phone = sc.nextLine();
                    System.out.print("Enter email: ");
                    String email = sc.nextLine();
                    manager.addContact(new Contact(name, phone, email));
                    System.out.println("Contact added!");
                    break;
                case 2:
                    // Listing all contacts
                    manager.listContacts();
                    break;
                case 3:
                    // Search contact by name
                    System.out.print("Enter name to search: ");
                    String searchName = sc.nextLine();
                    Contact found = manager.searchByName(searchName);
                    if (found != null) {
                        System.out.println("Contact found: " + found);
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;
                case 4:
                    // Exit
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again please.");


            }
        }
    }
}


class Contact {
    private String name;
    private String phoneNumber;
    private String email;

    public Contact (String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    //Getters for contact details
    public String getName() {
        return name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getEmail() {
        return email;
    }

    // toString method
    @Override
    public String toString() {
        return "Name: " + name+ ", Phone: "+ phoneNumber+ ", Email: "+ email;
    }

}

//ContactManager class usese an ArrayList to store contacts

class ContactManager {
    private List<Contact> contactList;
    // HashMap for fast search
    private Map<String, Contact> contactMap;

public ContactManager() {
    contactList = new ArrayList<>(); 
    contactMap = new HashMap<>();
    }

// Adds a contact to both the list and the map.
public void addContact(Contact contact) {
    contactList.add(contact);
// Convert name to lowercase for case-insensitive search
contactMap.put(contact.getName().toLowerCase(), contact);
}

// List all contacts stored in the collection
public void listContacts() {
    if (contactList.isEmpty()) {
        System.out.println("No contacts found.");
    } else {
        System.out.println("Contacts List");
        for (Contact contact : contactList) {
            System.out.println(contact);
            }
        }
     }

// Looks up a contact by name using the HashMap
public Contact searchByName(String name) {
    return contactMap.get(name.toLowerCase());
    }

}



