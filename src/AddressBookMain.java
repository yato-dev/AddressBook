import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();

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