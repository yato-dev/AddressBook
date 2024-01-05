import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

class AddressBook {
    private List<Contact> contacts;

    public AddressBook() {
        this.contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        if (!contacts.contains(contact)) {
            contacts.add(contact);
            System.out.println("Contact added successfully!");
        } else {
            System.out.println("Duplicate entry. Contact with the same name already exists.");
        }
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

    public List<Contact> searchPersonsByCity(String city) {

        return contacts.stream()
                .filter(contact -> contact.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }

    public List<Contact> searchPersonsByState(String state) {

        return contacts.stream()
                .filter(contact -> contact.getState().equalsIgnoreCase(state))
                .collect(Collectors.toList());
    }

    public Map<String, List<Contact>> getPersonsByCity() {

        return contacts.stream()
                .collect(Collectors.groupingBy(Contact::getCity));
    }

    public Map<String, List<Contact>> getPersonsByState() {

        return contacts.stream()
                .collect(Collectors.groupingBy(Contact::getState));
    }

    public Map<String, Long> countPersonsByCity() {
       
        return contacts.stream()
                .collect(Collectors.groupingBy(Contact::getCity, Collectors.counting()));
    }
    
    public Map<String, Long> countPersonsByState() {
 
        return contacts.stream()
                .collect(Collectors.groupingBy(Contact::getState, Collectors.counting()));
    }

    public void sortByName() {
        contacts.sort(Comparator.comparing(Contact::getFirstName).thenComparing(Contact::getLastName));
    }

    public void sortByCity() {
        contacts.sort(Comparator.comparing(Contact::getCity));
    }
    
    public void sortByState() {
        contacts.sort(Comparator.comparing(Contact::getState));
    }
    
    public void sortByZip() {
        contacts.sort(Comparator.comparing(Contact::getZip));
    }

    public void writeToFile(String filePath) {
        try {
            FileOutputStream writeData = new FileOutputStream("data.txt");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            writeStream.writeObject(contacts);
            writeStream.flush();
            writeStream.close();
            System.out.println("Contacts are write to file: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void readFromFile(String filePath) {
        try {
            FileInputStream readData = new FileInputStream("data.txt");
            ObjectInputStream readStream = new ObjectInputStream(readData);

            ArrayList<Contact> contacts2 = (ArrayList<Contact>) readStream.readObject();
            readStream.close();
            contacts.addAll(contacts2);
            System.out.println(contacts2.toString());
        } catch (Exception e) {
            e.printStackTrace();
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