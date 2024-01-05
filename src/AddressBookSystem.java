import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookSystem {

    private Map<String, AddressBook> addressBooks;

    public AddressBookSystem() {
        this.addressBooks = new HashMap<>();
    }

    public void addAddressBook(String name) {
        if (!addressBooks.containsKey(name)) {
            addressBooks.put(name, new AddressBook());
            System.out.println("Address book '" + name + "' added successfully!");
        } else {
            System.out.println("Address book with the name '" + name + "' already exists.");
        }
    }

    public void operateOnAddressBook(String name) {
        AddressBook addressBook = addressBooks.get(name);
        if (addressBook == null) {
            System.out.println("Address book with the name '" + name + "' does not exist.");
            return;
        }

  
       

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Add a new contact");
            System.out.println("2. Edit an existing contact");
            System.out.println("3. Delete a contact");
            System.out.println("4. Display contacts");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:{
                System.out.println("Enter first name:");
                String firstName = scanner.nextLine();
                System.out.println("Enter last name:");
                String lastName = scanner.nextLine();
                System.out.println("Enter address:");
                String address = scanner.nextLine();
                System.out.println("Enter city:");
                String city = scanner.nextLine();
                System.out.println("Enter state:");
                String state = scanner.nextLine();
                System.out.println("Enter zip:");
                String zip = scanner.nextLine();
                System.out.println("Enter phone number:");
                String phoneNumber = scanner.nextLine();
                System.out.println("Enter email:");
                String email = scanner.nextLine();
                Contact newContact = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);
                addressBook.addContact(newContact);
                }
                    break;

                case 2:
                {
                System.out.println("Enter the name of the contact to edit:");
                String contactName = scanner.nextLine();
                addressBook.editContact(contactName);
                  }
                break;

                case 3:
                    System.out.println("Enter the name of the contact to delete:");
                    String contactNameToDelete = scanner.nextLine();
                    addressBook.deleteContact(contactNameToDelete);
                    break;

                case 4:
                addressBook.displayContacts();
                break;

                case 5:
                    System.out.println("Exiting the address book.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }


    }

}
