import java.io.*;

public class FileController extends Controller {

    private File dataFolder;

    private File contactFolder;

    public FileController(String dataPath) {

            dataFolder = new File("C:/Users/" + dataPath);
            if (!dataFolder.exists()) {
                dataFolder.mkdirs();
            }

            contactFolder = new File("C:/Users/" + dataPath + "/contacts");
            if (!contactFolder.exists()) {
                contactFolder.mkdirs();
            }
    }


    @Override
    public void contactCreation(String[] info) {
        try {
            super.contactCreation(info);
            File contact = new File("C:/Users/ContactsInfo/" + idCount + ".txt");
            contact.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Contacte updatingContacte(int selectedID, String changeName, String changeSur, String changePhone, String changeMail) {

        return super.updatingContacte(selectedID, changeName, changeSur, changePhone, changeMail);



    }

    @Override
    public void deleteContact(int givenID) {
        super.deleteContact(givenID);
    }
}
