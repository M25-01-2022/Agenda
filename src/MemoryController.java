import java.lang.reflect.Field;
import java.util.List;
public class MemoryController implements Controller {

    private List<Contacte> contacts;

    protected int idCount = 1;

    public MemoryController() {
    }

    public int getIdCount() {
        return idCount;
    }

    public void upIDCount (int idCount) {
        this.idCount = ++idCount;
    }

    protected void setContactID(Contacte a, int idCount) {
        try {
            Field idField = a.getClass().getDeclaredField("ID");
            idField.setAccessible(true);
            idField.setInt(a, idCount);
            upIDCount(idCount);
            idField.setAccessible(false);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void contactCreation(String[] info) {
    }


    protected List<Contacte> getContacts() {
        return contacts;
    }

}