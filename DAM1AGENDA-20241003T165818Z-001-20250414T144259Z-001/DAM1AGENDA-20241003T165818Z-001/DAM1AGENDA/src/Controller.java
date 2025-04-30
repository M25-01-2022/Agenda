import java.util.ArrayList;

public class Controller {

    protected int idCount = 0;

    ArrayList<Contacte> contactsList = new ArrayList<>();

    public void contactCreation(String[] info, int idCount) {

        Contacte a = new Contacte(idCount, info[0], info[1], info[2], info[3]);

        contactsList.add(a);

        setIdCount(idCount);

    }

    public void setIdCount(int idCount) {
        idCount++;
        this.idCount = idCount;
    }
}
