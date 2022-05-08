package gr.aueb.cf.testbed.projectsA.projects;

import java.util.Arrays;
import java.util.Scanner;

public class Project02 {

    public static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        String[][] contacts = new String[15][3];

        int choice;
        int contactIndex = 0;

        do {
            showMenu();
            choice = in.nextInt();

            switch (choice) {
                case 1:
                    searchContact(contacts);
                    in.nextLine();
                    break;
                case 2:
                    if (addContact(contactIndex, contacts)) {
                        contactIndex++;
                    };
                    in.nextLine();
                    break;
                case 3:
                    updateContact(contacts);
                    in.nextLine();
                    break;
                case 4:
                    deleteContact(contacts);
                    in.nextLine();
                    break;
                case 5:
                    System.out.println("MY CONTACT LIST");
                    System.out.println("---------------");
                    arrayPrint(contacts);
                    System.out.println();
                    break;
                case 6:
                    System.out.println("Bye!");
                    choice = -1;
                    break;
                default:
                    System.out.println("Invalid Choice!");
                    break;

            }

        } while (choice != -1);


    }

    public static void showMenu() {
        System.out.println("MY CONTACT LIST");
        System.out.println("----------------");
        System.out.println("1 | Search Contact by phone number.");
        System.out.println("2 | Create New Contact.");
        System.out.println("3 | Update Contact details.");
        System.out.println("4 | Delete Contact.");
        System.out.println("5 | Show all contacts.");
        System.out.println("6 | Exit");
        System.out.println("----------------");
        System.out.println("What do you want to do?");
    }

    public static void searchContact(String[][] array) {

        in.nextLine();
        int phoneEntered;
        try {
            System.out.println("Enter phone number: ");
            phoneEntered = in.nextInt();
            boolean found = false;

            for (int i = 0; i < array.length; i++) {
                if (phoneEntered == Integer.parseInt(array[i][2])) {
                    found = true;
                    System.out.println("Contact Found. Last Name: "+array[i][0]+" First name: "+array[i][1]);
                    i = array.length -1;
                }

            }
        } catch (Exception e) {
            System.out.println("Contact not found.");

        }
    }

    public static boolean addContact(int contactIndex, String[][] contacts) {


        String[][] newContact = new String[1][3];

        System.out.println("Enter Last Name: ");
        newContact[0][0] = in.next();
        System.out.println("Enter First Name: ");
        newContact[0][1] = in.next();
//        try {
            System.out.println("Enter Phone Number: ");
            newContact[0][2] = in.next();
            //newContact[0][2] = Integer.toString(in.nextInt());
//        }
//        catch (Exception e) {
//            System.out.println("Invalid phone number. Try using digits.");
//        }


            if (contactExists(newContact,contacts)) {
                System.out.println("Contact already exists. Try again!");
                return false;
            } else {
                for (int i=0; i < contacts[contactIndex].length; i++) {
                contacts[contactIndex][i] = newContact[0][i];
                }
                for (String[] item : newContact) {
                    System.out.println("New Contact Created: " + Arrays.toString(item) + ", ");
                }
                return true;
            }

       // return contacts;
    }

    public static void updateContact (String[][] contacts) {

        in.nextLine();
        int phoneEntered;
        try {
            System.out.println("Enter phone number: ");
            phoneEntered = in.nextInt();
            boolean found = false;

            for (int i = 0; i < contacts.length; i++) {
                if (phoneEntered == Integer.parseInt(contacts[i][2])) {
                    found = true;
                    System.out.println("Contact Found. Last Name: "+contacts[i][0]+" First name: "+contacts[i][1]);
                    System.out.println("Enter Updated details:");
                    String[][] newContact = new String[1][3];

                    System.out.println("Enter Last Name: ");
                    newContact[0][0] = in.next();
                    System.out.println("Enter First Name: ");
                    newContact[0][1] = in.next();
                    System.out.println("Enter Phone Number: ");
                    newContact[0][2] = in.next();

                    for (int j=0; j < contacts[i].length; j++) {
                        contacts[i][j] = newContact[0][j];
                    }
                    for (String[] item : newContact) {
                        System.out.println("Contact Updated: Last Name: "+contacts[i][0]+" First name: "+contacts[i][1]);
                    }
                    i = contacts.length -1;
                }
            }
        } catch (Exception e) {
            System.out.println("Contact not found.");
        }
    }

    public static void deleteContact (String[][] contacts) {

        in.nextLine();
        int phoneEntered;
        try {
            System.out.println("Enter phone number: ");
            phoneEntered = in.nextInt();

            for (int i = 0; i < contacts.length; i++) {
                if (phoneEntered == Integer.parseInt(contacts[i][2])) {

                    System.out.println("Contact Found. Last Name: "+contacts[i][0]+" First name: "+contacts[i][1]);
                    System.out.println("CONFIRM DELETION. 1 TO CONFIRM. 2 TO DISCARD");

                    int delChoice = in.nextInt();

                    if (delChoice == 1) {
                        Arrays.fill(contacts[i], null);
                        i = contacts.length -1;
                    }


                }

            }
        } catch (Exception e) {
              System.out.println("Contact not found.");

        }


    }

    public static boolean contactExists(String[][] newContact, String[][] contacts) {

        int existsCounter = 0;
        boolean exists = false;

        for (int i = 0; i < contacts.length; i++){
            existsCounter =0;
            for (int j = 0; j < contacts[i].length; j++){

                if ((newContact[0][j]).equals(contacts[i][j])) {
                    existsCounter++;

                    if (existsCounter == 3){
                        exists = true;
                    }
                }
            }
        }
        return exists;
    }

    public static void arrayPrint(String[][] contacts) {
        for (int i = 0; i < contacts.length; i++) {
            for (int j = 0; j < contacts[i].length; j++) {
                System.out.print(contacts[i][j]+" ");
            }
            System.out.println();
        }
    }

}
