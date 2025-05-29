import java.lang.reflect.Field;

public class MemoryController implements Controller {

    protected int idCount = 1;

    public MemoryController() {

    }

    @Override
    public void contactCreation(String[] info) {
        Contacte a = new Contacte(info[0], info[1], info[2], info[3]);
        contactsList.put(a.getID(), a);
        setIdCount(idCount);
    }

    public void setIdCount(int idCount) {
        idCount++;
        this.idCount = idCount;
    }

    protected void setContactID(Contacte c, int id) {
        try {
            Field idField = c.getClass().getDeclaredField("ID");
            idField.setAccessible(true);
            idField.setInt(c, id);
            idField.setAccessible(false);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}