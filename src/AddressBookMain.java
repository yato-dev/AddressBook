import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddressBookSystem addressBookSystem = new AddressBookSystem();

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Add a new Address Book");
            System.out.println("2. Operate on an existing Address Book");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.println("Enter the name for the new Address Book:");
                    String newAddressBookName = scanner.nextLine();
                    addressBookSystem.addAddressBook(newAddressBookName);
                    break;

                case 2:
                    System.out.println("Enter the name of the Address Book to operate on:");
                    String existingAddressBookName = scanner.nextLine();
                    addressBookSystem.operateOnAddressBook(existingAddressBookName);
                    break;

                case 3:
                    System.out.println("Exiting the address book system.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}