import java.util.InputMismatchException;
import java.util.Scanner;

public class TUI {

    Scanner sc = new Scanner(System.in);

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
                    updateSelect();
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

    public void updateSelect() {

        showLine("Please input the ID of the contact that you want to update:");

        int selectedID = sc.nextInt();

        showLine("You will now update the contact. If you do not want to change a field, input an asterisk (*).");
        showLine("Name:");

        String changeName = sc.next();

        showLine("Surname:");

        String changeSur = sc.next();

        showLine("Phone:");

        String changePhone = sc.next();

        showLine("Email:");

        String changeMail = sc.next();

        showLine("Your contact has been updated, the new fields are:");

        showLine(String.valueOf(Main.updation(selectedID, changeName, changeSur, changePhone, changeMail)));



    }

    public void showAllContacts() {
        showLine(String.valueOf(Main.revelation()));
    }

    public void summonDeletionMenu() {

        try {

            showLine("Please input the ID of the contact you want to delete.");

            int givenID = sc.nextInt();

            Main.deletion(givenID);

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
                searchID();
            } else if (actionSearch == 2) {
                showLine("Searching by name...");
                searchName();
            } else if (actionSearch == 3) {
                showLine("Searching by surname...");
                searchSurname();
            } else if (actionSearch == 4) {
                showLine("Searching by phone number...");
                searchPhone();
            } else if (actionSearch == 5) {
                showLine("Searching by email...");
                searchEmail();
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

    public void searchID () {

        showLine("Please input the ID of the contact you wish to view:");

        int inputID = sc.nextInt();

        showLine(String.valueOf(Main.findID(inputID)));

    }

    public void searchName () {

        showLine("Please input the name of the contact you wish to view:");

        String inputName = sc.next();

        showLine(String.valueOf(Main.findName(inputName)));

    }

    public void searchSurname () {

        showLine("Please input the surname of the contact you wish to view:");

        String inputSur = sc.next();

        showLine(String.valueOf(Main.findSurname(inputSur)));

    }

    public void searchPhone () {

        showLine("Please input the phone number of the contact you wish to view:");

        String inputPhone = sc.next();

        showLine(String.valueOf(Main.findPhone(inputPhone)));

    }

    public void searchEmail () {

        showLine("Please input the email address of the contact you wish to view:");

        String inputMail = sc.next();

        showLine(String.valueOf(Main.findEmail(inputMail)));

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

            showLine("Your new contact has been added!");

            Main.creation(info);


            showLine("ID: " + Main.currentID());
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