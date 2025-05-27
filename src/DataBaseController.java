import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.logging.Level;

// Sources:
//      https://docs.jboss.org/hibernate/orm/6.6/quickstart/html_single/
//      https://www.baeldung.com/hibernate-criteria-queries
//      https://hibernate.org/orm/quickly/

public class DataBaseController implements Controller, AutoCloseable  {
    private final SessionFactory factory;
    private final Session session;
    private final CriteriaBuilder criteriaBuilder;

    public DataBaseController(){
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        this.factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        this.session = this.factory.openSession();
        this.criteriaBuilder = this.factory.getCriteriaBuilder();
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
