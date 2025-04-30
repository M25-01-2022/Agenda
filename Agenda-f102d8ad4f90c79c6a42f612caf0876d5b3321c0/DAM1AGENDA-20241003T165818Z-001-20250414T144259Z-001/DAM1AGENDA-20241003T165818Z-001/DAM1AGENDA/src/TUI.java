import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TUI {

    Scanner sc = new Scanner(System.in);

    Controller ctrl = new Controller();

    public void summonMainMenu() {

        while (true) {
            try {
                // prompting the user to choose an option
                showLine("Welcome to the agenda, please choose an option:");
                showLine(" 1. Create new contact.");
                showLine(" 2. Search for existing contacts.");
                showLine(" 3. Update an existing contact.");
                showLine(" 4. Delete an existing contact.");
                showLine(" 5. Show all existing contacts.");
                showLine(" 6. Exit.");

                // taking an input number from user
                int actionMenu = sc.nextInt();

                //possible actions
                if (actionMenu == 1) {
                    showLine("Creating new contact...");
                    newContactInfo();
                } else if (actionMenu == 2) {
                    showLine("Searching for existing contacts...");
                    summonSearchMenu();
                } else if (actionMenu == 3) {
                    showLine("Updating existing contact...");
                } else if (actionMenu == 4) {
                    showLine("Deleting existing contact...");
                    summonDeletionMenu();
                } else if (actionMenu == 5) {
                    showLine("Showing all existing contacts...");
                    showAllContacts();
                } else if (actionMenu == 6){
                    showLine("Exiting the agenda...");
                    System.exit(0);
                } else {
                    showLine("Input not recognized, please choose an option.");

                }

            } catch (InputMismatchException java_error) {
                // catching the error, returning the menu
                showLine("Input not recognized, please choose an option.");
                summonMainMenu();
            }

            sc.nextLine();
        }

    }

    public void showAllContacts() {
        contactsPrint(ctrl.contactDump());
    }

    public void contactsPrint(ArrayList<Contacte> contactes) {
        System.out.print(contactes);
    }

    public void summonDeletionMenu() {

        try {

            showLine("Please input the ID of the contact you want to delete.");

            int givenID = sc.nextInt();

        ctrl.deleteContact(givenID);

        } catch (InputMismatchException java_error) {
            // catching the error, returning the menu
            showLine("Input not recognized, please choose a valid ID.");
            summonDeletionMenu();
        }

        showLine("The contact has been deleted.");

        try {

            showLine("What would you like to do now?");
            showLine(" 1. Delete another contact.");
            showLine(" 2. Return to the main menu.");

            int actionDelete = sc.nextInt();

            if (actionDelete == 1) {
                summonDeletionMenu();
            } else if (actionDelete == 2) {
                summonMainMenu();
            } else {
                showLine("Input not recognized, please choose an option.");
            }

        } catch (InputMismatchException java_error) {
            // catching the error, returning the menu
            showLine("Input not recognized, please choose an option.");
        }

    }

    public void summonSearchMenu() {

        showLine("Welcome to the search menu, please choose preferred search method:");
        showLine(" 1. Search by ID number.");
        showLine(" 2. Search by name.");
        showLine(" 3. Search by surname.");
        showLine(" 4. Search by phone number.");
        showLine(" 5. Search by email.");
        showLine(" 6. Return to the main menu.");

                searchContact();

        }



    public void searchContact() {

            try {

                int actionSearch = sc.nextInt();

                if (actionSearch == 1) {
                    showLine("Searching by ID number...");
                } else if (actionSearch == 2) {
                    showLine("Searching by name...");
                } else if (actionSearch == 3) {
                    showLine("Searching by surname...");
                } else if (actionSearch == 4) {
                    showLine("Searching by phone number...");
                } else if (actionSearch == 5) {
                    showLine("Searching by email...");
                } else if (actionSearch == 6) {
                    showLine("Returning to main menu...");
                    summonMainMenu();
                } else {
                    showLine("Input not recognized, please choose an option.");
                    summonSearchMenu();
                }
            } catch (InputMismatchException java_error) {
                // catching the error, returning the menu
                showLine("Input not recognized, please choose an option.");
                summonSearchMenu();
            }
    }
    public void newContactInfo() {

        try {

            showLine("Choose the name for your new contact:");

            String name = sc.next();

            showLine("Choose the surname for your new contact:");

            String surname = sc.next();

            showLine("Input your new contact's phone number:");

            String phone = sc.next();

            showLine("Input your new contacts email address:");

            String emailAdd = sc.next();

        String[] info = {name,surname,phone,emailAdd};

        ctrl.contactCreation(info, ctrl.idCount);

            showLine("Your new contact has been added!");
            showLine("ID: " + ctrl.idCount);
            showLine("Name: " + name);
            showLine("Surname: " + surname);
            showLine("Phone Number: " + phone);
            showLine("Email Address: " + emailAdd);
            showLine("");

        } catch (InputMismatchException java_error) {
            // catching the error, returning the menu
            showLine("Input not recognized, restarting contact creation.");
            newContactInfo();
        }

        try {
            showLine("What would you like to do now?");
            showLine("1. Add another new contact.");
            showLine("2. Return to the main menu.");

            int actionCreate = sc.nextInt();

            if (actionCreate == 1) {
                newContactInfo();
            } else if (actionCreate == 2){
                summonMainMenu();
            } else {
                showLine("Input not recognized, please choose an option.");
            }

        } catch (InputMismatchException java_error) {
            // catching the error, returning the menu
            showLine("Input not recognized, please choose an option.");
        }
    }

    public void showLine(String output) {
        System.out.println(output);
    }
}
