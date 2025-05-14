import java.io.*;

public class FileController extends Controller {

    private File dataFolder;

    private File contactFolder;

    public FileController(String dataPath) {

            dataFolder = new File("C:/Users/" + dataPath);
            if (!dataFolder.exists()) {
                dataFolder.mkdirs();
                System.out.println("created");
            }

            contactFolder = new File("C:/Users/" + dataPath + "/contacts");
            if (!contactFolder.exists()) {
                contactFolder.mkdirs();
                System.out.println("created2");
            }
    }


    @Override
    public void contactCreation(String[] info) {
        try {
            super.contactCreation(info);
            FileWriter contact = new FileWriter(contactFolder + "/" + idCount + ".txt", true);
            contact.write(String.valueOf(contactsList.get(idCount - 1)));
            contact.close();
            setIdCount(idCount);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Contacte updatingContacte(int selectedID, String changeName, String changeSur, String changePhone, String changeMail) {
        try {
            super.updatingContacte(selectedID, changeName, changeSur, changePhone, changeMail);
            FileWriter updateContact = new FileWriter (contactFolder + "/" + selectedID + ".txt", false);
            updateContact.write(String.valueOf(contactsList.get(selectedID - 1)));
            updateContact.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return super.updatingContacte(selectedID, changeName, changeSur, changePhone, changeMail);
    }

    @Override
    public void deleteContact(int givenID) {
        super.deleteContact(givenID);
    }
}
