import java.util.ArrayList;

public abstract class Controller {

    protected int idCount = 1;

    ArrayList<Contacte> contactsList = new ArrayList<>();

    public void contactCreation(String[] info) {
        Contacte a = new Contacte(idCount, info[0], info[1], info[2], info[3]);
        contactsList.add(a);
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

    public ArrayList<Contacte> contactDump() {
        return contactsList;
    }

    public Contacte searchingID(int inputID) {

        Contacte foundIt = null;
        for (int i = 0; i < contactsList.size(); i++) {
            if (inputID == contactsList.get(i).getId()) {
                foundIt = contactsList.get(i);
                break;
            }
        }
        if (foundIt == null) {
            System.out.println("The contact you are looking for with ID '" + inputID + "' does not exist. \nIs");
        }
        return foundIt;
    }

    public Contacte searchingName(String inputName) {

        Contacte foundIt = null;
        for (int i = 0; i < contactsList.size(); i++) {
            if (inputName.equalsIgnoreCase(contactsList.get(i).getNom())) {

                foundIt = contactsList.get(i);
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
            if (inputSur.equalsIgnoreCase(contactsList.get(i).getCognom())) {

                foundIt = contactsList.get(i);
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
            if (inputPhone.equalsIgnoreCase(contactsList.get(i).getTelefon())) {

                foundIt = contactsList.get(i);
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
            if (inputMail.equalsIgnoreCase(contactsList.get(i).getEmail())) {

                foundIt = contactsList.get(i);
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
            if (selectedID == contactsList.get(i).getId()) {
                if (changeName.equalsIgnoreCase("*")) {
                    break;
                } else {
                    contactsList.get(i).setNom(changeName);
                }
                if (changeSur.equalsIgnoreCase("*")) {
                    break;
                } else {
                    contactsList.get(i).setCognom(changeSur);
                }
                if (changePhone.equalsIgnoreCase("*")) {
                    break;
                } else {
                    contactsList.get(i).setTelefon(changePhone);
                }
                if (changeMail.equalsIgnoreCase("*")) {
                    break;
                } else {
                    contactsList.get(i).setEmail(changeMail);
                }
                changedIt = contactsList.get(i);

            }
        }
        return changedIt;
    }
}