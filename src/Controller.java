import java.util.*;

public abstract class Controller {

    protected int idCount = 1;

    HashMap<Integer, Contacte> contactsList = new HashMap<>();

    public void contactCreation(String[] info) {
        Contacte a = new Contacte(idCount, info[0], info[1], info[2], info[3]);
        contactsList.put(a.getId(), a);
        setIdCount(idCount);
    }

    public void setIdCount(int idCount) {
        idCount++;
        this.idCount = idCount;
    }

    public int currentIDCount() {
        return this.idCount - 1;
    }

    public void deleteContact(int givenID) {
        if (contactsList.containsKey(givenID)) {
            contactsList.remove(givenID);
            System.out.println("Contact with ID " + givenID + " removed.");
        } else {
            System.out.println("There is no contact with ID " + givenID + ".");
        }
    }


    public Map<Integer, Contacte> contactDump() {
        return contactsList;
    }

    public Contacte searchingID(int inputID) {
        if (contactsList.containsKey(inputID)) {
            Contacte foundIt = contactsList.get(inputID);
            System.out.println("Contact found:");
            return foundIt;
        } else {
            System.out.println("The contact you are looking for with ID '" + inputID + "' does not exist.");
            return null;
        }
    }


    public Contacte searchingName(String inputName) {
        Contacte foundIt = null;

        for (Contacte current : contactsList.values()) {
            if (current != null && inputName.equalsIgnoreCase(current.getNom())) {
                foundIt = current;
                break;
            }
        }

        if (foundIt == null) {
            System.out.println("The contact you are looking for with name '" + inputName + "' does not exist.");
        }

        return foundIt;
    }


    public Contacte searchingSurname(String inputSur) {
        Contacte foundIt = null;

        for (Contacte current : contactsList.values()) {
            if (current != null && inputSur.equalsIgnoreCase(current.getCognom())) {
                foundIt = current;
                break;
            }
        }

        if (foundIt == null) {
            System.out.println("The contact you are looking for with surname '" + inputSur + "' does not exist.");
        }

        return foundIt;
    }

    public Contacte searchingPhone(String inputPhone) {
        Contacte foundIt = null;
        for (Contacte current : contactsList.values()) {
            if (current != null && inputPhone.equalsIgnoreCase(current.getTelefon())) {
                foundIt = current;
                break;
            }
        }
        if (foundIt == null) {
            System.out.println("The contact you are looking for with phone '" + inputPhone + "' does not exist.");
        }
        return foundIt;
    }

    public Contacte searchingEmail(String inputMail) {

        Contacte foundIt = null;
        for (Contacte current : contactsList.values()) {
            if (current != null && inputMail.equalsIgnoreCase(current.getEmail())) {

                foundIt = current;
                break;
            }
        }
        if (foundIt == null) {
            System.out.println("The contact you are looking for with mail '" + inputMail + "' does not exist. \nIs");
        }
        return foundIt;
    }

    public Contacte updatingContacte(int selectedID, String changeName, String changeSur, String changePhone, String changeMail) {
        Contacte current = contactsList.get(selectedID);

        if (current != null) {
            if (!changeName.equals("*")) {
                current.setNom(changeName);
            }

            if (!changeSur.equals("*")) {
                current.setCognom(changeSur);
            }

            if (!changePhone.equals("*")) {
                current.setTelefon(changePhone);
            }

            if (!changeMail.equals("*")) {
                current.setEmail(changeMail);
            }
            contactsList.put(selectedID, current);
        } else {
            System.out.println("Contact with ID " + selectedID + " not found.");
        }

        return current;
    }
}