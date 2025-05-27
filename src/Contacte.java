import java.util.List;
import java.util.logging.Level;

public class Contacte {

    protected int id;
    protected String nom;
    protected String cognom;
    protected String telefon;
    protected String email;

    public Contacte(int id, String nom, String cognom, String telefon, String email) {
        this.id = id;
        this.nom = nom;
        this.cognom = cognom;
        this.telefon = telefon;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getCognom() {
        return cognom;
    }

    public String getTelefon() {
        return telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString(){
        return "\nID: " + id + "\nName: " + nom + "\nSurname: " + cognom + "\nPhone: " + telefon + "\nEmail: " + email + "\n--------\n";
    }

    public static class DataBaseController implements Controller, AutoCloseable  {
        private final SessionFactory factory;
        private final Session session;
        private final CriteriaBuilder criteriaBuilder;

        public DataBaseController(){
            java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
            this.factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            this.session = this.factory.openSession();
            this.criteriaBuilder = this.factory.getCriteriaBuilder();
        }

        public void close() throws Exception {
            this.session.close();
            this.factory.close();
        }

        public Contact nouContacte(String name, String surnames, String phone, String email) {
            Contact c = new Contact(name, surnames, phone, email);
            Transaction transaction = this.session.beginTransaction();
            this.session.persist(c);
            transaction.commit();

            return c;
        }

        public Contact actualitzarContacte(int ID, String name, String surnames, String phone, String email) {
           //TODO: implementation pending...
           return null;
        }

        public void esborrarContacte(int ID){
           //TODO: implementation pending...
           return null;
        }

        public Contact cercarContactePerID(int ID){
            return this.session.get(Contact.class, ID);
        }

        public List<Contact> cercarContactesPerNom(String name){
           //TODO: implementation pending...
           return null;
        }

        public List<Contact> cercarContactesPerCognoms(String surnames){
           //TODO: implementation pending...
           return null;
        }

        public List<Contact> cercarContactesPerTelefon(String phone){
           //TODO: implementation pending...
           return null;
        }

        public List<Contact> cercarContactesPerEmail(String email){
           //TODO: implementation pending...
           return null;
        }

        public List<Contact> getContactes() {
            CriteriaQuery<Contact> cr = this.criteriaBuilder.createQuery(Contact.class);
            Root<Contact> root = cr.from(Contact.class);

            CriteriaQuery<Contact> query = cr.select(root);
            return this.session.createQuery(query).getResultList();
        }

        private List<Contact> cercarContactesPerCamp(String camp, String valor){
            CriteriaQuery<Contact> cr = this.criteriaBuilder.createQuery(Contact.class);
            Root<Contact> root = cr.from(Contact.class);

            CriteriaQuery<Contact> query = cr.select(root).where(this.criteriaBuilder.like(root.get(camp), "%" + valor + "%"));
            return this.session.createQuery(query).getResultList();
        }
    }
}