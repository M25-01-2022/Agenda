import java.io.File;

public class FileController extends Controller{

    private File dataFolder;

    private File contactFolder;

    @Override
    public void contactCreation(String[] info) {
        super.contactCreation(info);
        File myFile = new File(String.valueOf(idCount));
    }

    @Override
    public Contacte updatingContacte(int selectedID, String changeName, String changeSur, String changePhone, String changeMail) {
        return super.updatingContacte(selectedID, changeName, changeSur, changePhone, changeMail);
    }

    @Override
    public void deleteContact(int givenID) {
        super.deleteContact(givenID);
    }

    public void createFolder(String dataPath){
        File dir = new File("contactes");
        if(dir.exists() && dir.isDirectory());
        else
            if(dir.mkdir());
            else throw new RuntimeException("Error: No se pudo crear el directorio '" + dir + "'.");

    }
}
