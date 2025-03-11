import java.util.ArrayList;
import java.util.List;

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
    private List<Contact> contacts;

    public ContactManager() {
        contacts = new ArrayList<>(); 
    }

// Add a new contacts stored in the collection
public void addContact(Contact contact) {
    contacts.add(contact);
}

// List all contacts stored in the collection
public void listContacts() {
    if (contacts.isEmpty()) {
        System.out.println("No contacts found.");
    } else {
        System.out.println("Contacts List");
        for (Contact contact : contacts) {
            System.out.println(contact);
            }
        }

    }

}

public class ContactManagerApp {
    public static void main(String[] args) {
        // instance of ContactManager
        ContactManager manager  = new ContactManager();
        
        // Add a sample conact
        Contact contact1 = new Contact("Bob Marley", "332-465-7586", "marley@gmail.com");
        manager.addContact(contact1);
        Contact contact2 = new Contact("Alice Smith", "718-865-9227", "marley@gmail.com");
        manager.addContact(contact2);

        // List all contacts 
        manager.listContacts();
    }
}