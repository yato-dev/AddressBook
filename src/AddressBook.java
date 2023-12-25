import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



class AddressBook {
    private List<Contact> contacts;

    public AddressBook() {
        this.contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        System.out.println("Contact added successfully!");
    }

    public void editContact(String name) {
        for (Contact contact : contacts) {
            if (contact.getFirstName().equalsIgnoreCase(name) || contact.getLastName().equalsIgnoreCase(name)) {
               
                Scanner scanner = new Scanner(System.in);

                System.out.println("Enter new address:");
                contact.setAddress(scanner.nextLine());
                System.out.println("Enter new city:");
                contact.setCity(scanner.nextLine());
                System.out.println("Enter new state:");
                contact.setState(scanner.nextLine());
                System.out.println("Enter new zip:");
                contact.setZip(scanner.nextLine());
                System.out.println("Enter new phone number:");
                contact.setPhoneNumber(scanner.nextLine());
                System.out.println("Enter new email:");
                contact.setEmail(scanner.nextLine());

                System.out.println("Contact edited successfully!");
                scanner.close();
                return;
            }
        }

      
        System.out.println("No contact found with the name: " + name);

       
    }
    public void deleteContact(String name) {
        int indexToDelete = -1;
    
        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            if (contact.getFirstName().equalsIgnoreCase(name) || contact.getLastName().equalsIgnoreCase(name)) {
                indexToDelete = i;
                break;
            }
        }
    
        if (indexToDelete != -1) {
            contacts.remove(indexToDelete);
            System.out.println("Contact deleted successfully!");
        } else {
            System.out.println("No contact found with the name: " + name);
        }
    }

    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Address book is empty.");
        } else {
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }
}