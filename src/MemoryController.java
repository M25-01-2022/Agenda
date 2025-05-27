public class MemoryController implements Controller {

    protected int idCount = 1;

    public MemoryController(int idCount) {
        this.idCount = idCount;
    }

    public MemoryController() {
    }

    @Override
    public void contactCreation(String[] info) {
        Contacte a = new Contacte(idCount, info[0], info[1], info[2], info[3]);
        contactsList.put(a.getId(), a);
        setIdCount(idCount);
    }

    public void setIdCount(int idCount) {
        idCount++;
        this.idCount = idCount;
    }









}