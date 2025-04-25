import java.util.InputMismatchException;
import java.util.Scanner;

public class TUI {

    Scanner sc = new Scanner(System.in);

    Controller ctrl = new Controller();

    public void summonMainMenu() {

        while (true) {
            try {
                // prompting the user to choose an option
                System.out.println("Welcome to the agenda, please choose an option:");
                System.out.println(" 1. Create new contact.");
                System.out.println(" 2. Search for existing contacts.");
                System.out.println(" 3. Update an existing contact.");
                System.out.println(" 4. Delete an existing contact.");
                System.out.println(" 5. Show all existing contacts.");
                System.out.println(" 6. Exit.");

                // taking an input number from user
                int actionMenu = sc.nextInt();

                //possible actions
                if (actionMenu == 1) {
                    System.out.println("Creating new contact...");
                    newContactInfo();
                } else if (actionMenu == 2) {
                    System.out.println("Searching for existing contacts...");
                    summonSearchMenu();
                } else if (actionMenu == 3) {
                    System.out.println("Updating existing contact...");
                } else if (actionMenu == 4) {
                    System.out.println("Deleting existing contact...");
                } else if (actionMenu == 5) {
                    System.out.println("Showing all existing contacts...");
                } else if (actionMenu == 6){
                    System.out.println("Exiting the agenda...");
                    System.exit(0);
                } else {
                    System.out.println("Input not recognized, please choose an option.");

                }

            } catch (InputMismatchException java_error) {
                // catching the error, returning the menu
                System.out.println("Input not recognized, please choose an option.");
                summonMainMenu();
            }

            sc.nextLine();
        }

    }

    public void summonSearchMenu() {

                System.out.println("Welcome to the search menu, please choose preferred search method:");
                System.out.println(" 1. Search by ID number.");
                System.out.println(" 2. Search by name.");
                System.out.println(" 3. Search by surname.");
                System.out.println(" 4. Search by phone number.");
                System.out.println(" 5. Search by email.");
                System.out.println(" 6. Return to the main menu.");

                searchContact();

        }



    public void searchContact() {

        while (true) {

            try {

                int actionSearch = sc.nextInt();

                if (actionSearch == 1) {
                    System.out.println("Searching by ID number...");
                } else if (actionSearch == 2) {
                    System.out.println("Searching by name...");
                } else if (actionSearch == 3) {
                    System.out.println("Searching by surname...");
                } else if (actionSearch == 4) {
                    System.out.println("Searching by phone number...");
                } else if (actionSearch == 5) {
                    System.out.println("Searching by email...");
                } else if (actionSearch == 6) {
                    System.out.println("Returning to main menu...");
                    summonMainMenu();
                } else {
                    System.out.println("Input not recognized, please choose an option.");
                    summonSearchMenu();
                }
            } catch (InputMismatchException java_error) {
                // catching the error, returning the menu
                System.out.println("Input not recognized, please choose an option.");
                summonSearchMenu();
            }
        }
    }
    public void newContactInfo() {

        try {

            System.out.println("Choose the name for your new contact:");

            String name = sc.next();

            System.out.println("Choose the surname for your new contact:");

            String surname = sc.next();

            System.out.println("Input your new contact's phone number:");

            String phone = sc.next();

            System.out.println("Input your new contacts email address:");

            String emailAdd = sc.next();

        String[] info = {name,surname,phone,emailAdd};

        ctrl.contactCreation(info);

        System.out.println("Your new contact has been added!");
        System.out.println("ID: " + ctrl.idCount);
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
        System.out.println("Phone Number: " + phone);
        System.out.println("Email Address: " + emailAdd);
        System.out.println();

        } catch (InputMismatchException java_error) {
            // catching the error, returning the menu
            System.out.println("Input not recognized, restarting contact creation.");
            newContactInfo();
        }

        try {
            System.out.println("What would you like to do now?");
            System.out.println("1. Add another new contact.");
            System.out.println("2. Return to the main menu.");

            int actionCreate = sc.nextInt();

            if (actionCreate == 1) {
                newContactInfo();
            } else if (actionCreate == 2){
                summonMainMenu();
            } else {
                System.out.println("Input not recognized, please choose an option.");
            }

        } catch (InputMismatchException java_error) {
            // catching the error, returning the menu
            System.out.println("Input not recognized, please choose an option.");
        }
    }
}
