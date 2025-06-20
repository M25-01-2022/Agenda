import java.util.*;

public class Main {

    static DataBaseController ctrl = new DataBaseController();
    static FileController fCtrl = new FileController(System.getProperty("user.dir"));

    public static void main(String[] args) {
        new GUI();
    }

    public static void creation(String[] info) {
        ctrl.contactCreation(info);
        fCtrl.contactCreation(info);
    }

    public static Contacte findID(int inputID) {
        return ctrl.searchingID(inputID);
    }

    public static Map<Integer, Contacte> findName(String inputName) {
        return ctrl.searchingName(inputName);
    }

    public static Map<Integer, Contacte> findSurname(String inputSur) {
        return ctrl.searchingSurname(inputSur);
    }

    public static Map<Integer, Contacte> findPhone(String inputPhone) {
        return ctrl.searchingPhone(inputPhone);
    }

    public static Map<Integer, Contacte> findEmail(String inputMail) {
        return ctrl.searchingEmail(inputMail);
    }

    public static void deletion(int givenID) {
        ctrl.deleteContact(givenID);
        fCtrl.deleteContact(givenID);
    }

    public static Map<Integer, Contacte> revelation() {
        return ctrl.contactDump();
    }

    public static Contacte updation(int selectedID, String changeName, String changeSur, String changePhone, String changeMail) {
        Contacte updated = ctrl.updatingContacte(selectedID, changeName, changeSur, changePhone, changeMail);
        fCtrl.updatingContacte(selectedID, changeName, changeSur, changePhone, changeMail);
        return updated;
    }
}
