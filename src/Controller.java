import java.util.*;

public abstract class Controller {

    protected int idCount = 1;

    HashMap<String, Contacte> contactsList = new HashMap<>();

    public void contactCreation(String[] info) {
        Contacte a = new Contacte(idCount, info[0], info[1], info[2], info[3]);
        contactsList.put(String.valueOf(a.getId()), a);
    }

    public void setIdCount(int idCount) {
        idCount++;
        this.idCount = idCount;
    }

    public int currentIDCount() {
        return this.idCount - 1;
    }

    public void deleteContact(int givenID) {

        for (int i = 0; i < contactsList.size(); i++) {
            if (givenID == contactsList.get(i).getId()) {
                contactsList.remove(i);
                return;
            }
        }
    }

    public HashMap<String, Contacte> contactDump() {
        return contactsList;
    }

    public Contacte searchingID(int inputID) {
        if (contactsList.containsKey(inputID)) {
            Contacte foundIt = contactsList.get(inputID);
            System.out.println("Contact found:");
            System.out.println(foundIt);
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
        for (int i = 0; i < contactsList.size(); i++) {
            Contacte current = contactsList.get(i);
            if (inputSur.equalsIgnoreCase(current.getCognom())) {

                foundIt = current;
                break;
            }
        }
        if (foundIt == null) {
            System.out.println("The contact you are looking for with surname '" + inputSur + "' does not exist. \nIs");
        }
        return foundIt;
    }

    public Contacte searchingPhone(String inputPhone) {
        Contacte foundIt = null;
        for (int i = 0; i < contactsList.size(); i++) {
            Contacte current = contactsList.get(i);
            if (inputPhone.equalsIgnoreCase(current.getTelefon())) {
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
        for (int i = 0; i < contactsList.size(); i++) {
            Contacte current = contactsList.get(i);
            if (inputMail.equalsIgnoreCase(current.getEmail())) {

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
        Contacte changedIt = null;

        for (int i = 0; i < contactsList.size(); i++) {
            Contacte current = contactsList.get(i);
            if (selectedID == current.getId()) {

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

                changedIt = current;
                break;
            }
        }
        return changedIt;
    }
}