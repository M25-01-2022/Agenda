import java.util.HashMap;
import java.util.Map;

public interface Controller {

    HashMap<Integer, Contacte> contactsList = new HashMap<>();

    void contactCreation(String[] info);

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


    default Map<Integer, Contacte> searchingName(String inputName) {
        Map<Integer, Contacte> foundIt = null;

        for (Contacte current : contactsList.values()) {
            if (current != null && inputName.equalsIgnoreCase(current.getName())) {
                foundIt = (Map<Integer, Contacte>) current;
                break;
            }
        }

        return foundIt;
    }


    default Map<Integer, Contacte> searchingSurname(String inputSur) {
        Map<Integer, Contacte> foundIt = null;

        for (Contacte current : contactsList.values()) {
            if (current != null && inputSur.equalsIgnoreCase(current.getSurnames())) {
                foundIt = (Map<Integer, Contacte>) current;
                break;
            }
        }

        return foundIt;
    }

    default Map<Integer, Contacte> searchingPhone(String inputPhone) {
        Map<Integer, Contacte> foundIt = null;
        for (Contacte current : contactsList.values()) {
            if (current != null && inputPhone.equalsIgnoreCase(current.getPhone())) {
                foundIt = (Map<Integer, Contacte>) current;
                break;
            }
        }
        return foundIt;
    }

    default Map<Integer, Contacte> searchingEmail(String inputMail) {

        Map<Integer, Contacte> foundIt = null;
        for (Contacte current : contactsList.values()) {
            if (current != null && inputMail.equalsIgnoreCase(current.getEmail())) {

                foundIt = (Map<Integer, Contacte>) current;
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