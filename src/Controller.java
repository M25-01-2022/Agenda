import java.util.HashMap;
import java.util.Map;

public interface Controller {

    HashMap<Integer, Contacte> contactsList = new HashMap<>();

    default void contactCreation(String[] info) {

    }

    default void deleteContact(int givenID) {
        if (contactsList.containsKey(givenID)) {
            contactsList.remove(givenID);
        }
    }


    default Map<Integer, Contacte> contactDump() {
        return contactsList;
    }

    default Contacte searchingID(int inputID) {
        Contacte foundIt = null;
        if (contactsList.containsKey(inputID)) {
            foundIt = contactsList.get(inputID);
        }
        return foundIt;
    }


    default Contacte searchingName(String inputName) {
        Contacte foundIt = null;

        for (Contacte current : contactsList.values()) {
            if (current != null && inputName.equalsIgnoreCase(current.getName())) {
                foundIt = current;
                break;
            }
        }

        return foundIt;
    }


    default Contacte searchingSurname(String inputSur) {
        Contacte foundIt = null;

        for (Contacte current : contactsList.values()) {
            if (current != null && inputSur.equalsIgnoreCase(current.getSurnames())) {
                foundIt = current;
                break;
            }
        }

        return foundIt;
    }

    default Contacte searchingPhone(String inputPhone) {
        Contacte foundIt = null;
        for (Contacte current : contactsList.values()) {
            if (current != null && inputPhone.equalsIgnoreCase(current.getPhone())) {
                foundIt = current;
                break;
            }
        }
        return foundIt;
    }

    default Contacte searchingEmail(String inputMail) {

        Contacte foundIt = null;
        for (Contacte current : contactsList.values()) {
            if (current != null && inputMail.equalsIgnoreCase(current.getEmail())) {

                foundIt = current;
                break;
            }
        }
        return foundIt;
    }

    default Contacte updatingContacte(int selectedID, String changeName, String changeSur, String changePhone, String changeMail) {
        Contacte current = contactsList.get(selectedID);

        if (current != null) {
            if (!changeName.equals("*")) {
                current.setName(changeName);
            }

            if (!changeSur.equals("*")) {
                current.setSurnames(changeSur);
            }

            if (!changePhone.equals("*")) {
                current.setPhone(changePhone);
            }

            if (!changeMail.equals("*")) {
                current.setEmail(changeMail);
            }
            contactsList.put(selectedID, current);
        }

        return current;
    }

}