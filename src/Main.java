import java.util.ArrayList;

public class Main {

    static FileController ctrl = new FileController();

    public static void main(String[] args) {

        TUI newMenu = new TUI();

        newMenu.summonMainMenu();

    }

    public static void creation(String[] info) {

        ctrl.contactCreation(info);

    }

    public static int currentID() {

        return ctrl.currentIDCount();

    }

    public static Contacte findID(int inputID) {

        return ctrl.searchingID(inputID);

    }

    public static Contacte findName(String inputName) {

        return ctrl.searchingName(inputName);

    }

    public static Contacte findSurname(String inputSur) {

        return ctrl.searchingSurname(inputSur);

    }

    public static Contacte findPhone(String inputPhone) {

        return ctrl.searchingPhone(inputPhone);

    }

    public static Contacte findEmail(String inputMail) {

        return ctrl.searchingEmail(inputMail);

    }

    public static void deletion(int givenID) {

        ctrl.deleteContact(givenID);

    }

    public static ArrayList<Contacte> revelation() {
        return ctrl.contactDump();
    }

    public static void updation(int selectedID, String changeName, String changeSur, String changePhone, String changeMail) {

        ctrl.updatingContacte(selectedID, changeName, changeSur, changePhone, changeMail);

    }




}