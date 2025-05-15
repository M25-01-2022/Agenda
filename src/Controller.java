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

        Contacte foundIt = contactsList.get(inputID);
        if (foundIt == null) {
            System.out.println("The contact you are looking for with ID '" + inputID + "' does not exist. \nIs");
        }
        return foundIt;
    }

    public Contacte searchingName(String inputName) {

        Contacte foundIt = null;
        for (int i = 0; i < contactsList.size(); i++) {
            if (inputName.equalsIgnoreCase(contactsList.getNom())) {

                foundIt = contactsList;
                break;
            }
        }
        if (foundIt == null) {
            System.out.println("The contact you are looking for with name '" + inputName + "' does not exist. \nIs");
        }
        return foundIt;
    }

    public Contacte searchingSurname(String inputSur) {

        Contacte foundIt = null;
        for (int i = 0; i < contactsList.size(); i++) {
            if (inputSur.equalsIgnoreCase(contactsList.getCognom())) {

                foundIt = contactsList;
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
            if (inputPhone.equalsIgnoreCase(contactsList.getTelefon())) {

                foundIt = contactsList;
                break;
            }
        }
        if (foundIt == null) {
            System.out.println("The contact you are looking for with phone '" + inputPhone + "' does not exist. \nIs");
        }
        return foundIt;
    }

    public Contacte searchingEmail(String inputMail) {

        Contacte foundIt = null;
        for (int i = 0; i < contactsList.size(); i++) {
            if (inputMail.equalsIgnoreCase(contactsList.getEmail())) {

                foundIt = contactsList;
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
            if (selectedID == contactsList.getId()) {
                if (changeName.equalsIgnoreCase("*")) {
                    break;
                } else {
                    contactsList.setNom(changeName);
                }
                if (changeSur.equalsIgnoreCase("*")) {
                    break;
                } else {
                    contactsList.setCognom(changeSur);
                }
                if (changePhone.equalsIgnoreCase("*")) {
                    break;
                } else {
                    contactsList.setTelefon(changePhone);
                }
                if (changeMail.equalsIgnoreCase("*")) {
                    break;
                } else {
                    contactsList.setEmail(changeMail);
                }
                changedIt = contactsList;

            }
        }
        return changedIt;
    }
}