import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

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

    public Map<Integer, Contacte> getContactes() {
        CriteriaQuery<Contacte> cr = this.criteriaBuilder.createQuery(Contacte.class);
        Root<Contacte> root = cr.from(Contacte.class);
        CriteriaQuery<Contacte> query = cr.select(root);

        List<Contacte> resultList = this.session.createQuery(query).getResultList();

        Map<Integer, Contacte> contacteMap = new HashMap<>();
        for (Contacte contacte : resultList) {
            contacteMap.put(contacte.getID(), contacte);
        }

        return contacteMap;
    }

    private Map<Integer, Contacte> cercarContactesPerCamp(String camp, String valor) {
        CriteriaQuery<Contacte> cr = this.criteriaBuilder.createQuery(Contacte.class);
        Root<Contacte> root = cr.from(Contacte.class);

        CriteriaQuery<Contacte> query = cr
                .select(root)
                .where(this.criteriaBuilder.like(root.get(camp), "%" + valor + "%"));

        List<Contacte> resultList = this.session.createQuery(query).getResultList();

        Map<Integer, Contacte> contacteMap = new HashMap<>();
        for (Contacte contacte : resultList) {
            contacteMap.put(contacte.getID(), contacte);
        }

        return contacteMap;
    }

    public void close() {
        this.session.close();
        this.factory.close();
    }

    @Override
    public void contactCreation(String[] info) {
        Contacte a = new Contacte(info[0], info[1], info[2], info[3]);
        Transaction transaction = this.session.beginTransaction();
        this.session.persist(a);
        transaction.commit();
        contactsList.put(a.getID(), a);
    }

    @Override
    public void deleteContact(int givenID) {
        Controller.super.deleteContact(givenID);
        Transaction transaction = this.session.beginTransaction();
        Contacte contact = session.get(Contacte.class, givenID);
        if (contact != null) {
            session.remove(contact);
        }
        transaction.commit();
    }

    @Override
    public Map<Integer, Contacte> contactDump() {
        return Controller.super.contactDump();
    }

    @Override
    public Contacte searchingID(int inputID) {
        return session.get(Contacte.class, inputID);
    }

    @Override
    public Map<Integer, Contacte> searchingName(String name) {
        CriteriaQuery<Contacte> query = criteriaBuilder.createQuery(Contacte.class);
        Root<Contacte> root = query.from(Contacte.class);
        query.select(root).where(criteriaBuilder.like(root.get("nom"), "%" + name + "%"));

        List<Contacte> results = session.createQuery(query).getResultList();

        Map<Integer, Contacte> resultMap = new HashMap<>();
        for (Contacte c : results) {
            resultMap.put(c.getID(), c);
        }
        return resultMap;
    }

    @Override
    public Map<Integer, Contacte> searchingSurname(String surname) {
        CriteriaQuery<Contacte> query = criteriaBuilder.createQuery(Contacte.class);
        Root<Contacte> root = query.from(Contacte.class);
        query.select(root).where(criteriaBuilder.like(root.get("cognom"), "%" + surname + "%"));

        List<Contacte> results = session.createQuery(query).getResultList();

        Map<Integer, Contacte> resultMap = new HashMap<>();
        for (Contacte c : results) {
            resultMap.put(c.getID(), c);
        }
        return resultMap;
    }

    @Override
    public Map<Integer, Contacte> searchingPhone(String phone) {
        CriteriaQuery<Contacte> query = criteriaBuilder.createQuery(Contacte.class);
        Root<Contacte> root = query.from(Contacte.class);
        query.select(root).where(criteriaBuilder.like(root.get("telefon"), "%" + phone + "%"));

        List<Contacte> results = session.createQuery(query).getResultList();

        Map<Integer, Contacte> resultMap = new HashMap<>();
        for (Contacte c : results) {
            resultMap.put(c.getID(), c);
        }
        return resultMap;
    }

    @Override
    public Map<Integer, Contacte> searchingEmail(String email) {
        CriteriaQuery<Contacte> query = criteriaBuilder.createQuery(Contacte.class);
        Root<Contacte> root = query.from(Contacte.class);
        query.select(root).where(criteriaBuilder.like(root.get("email"), "%" + email + "%"));

        List<Contacte> results = session.createQuery(query).getResultList();

        Map<Integer, Contacte> resultMap = new HashMap<>();
        for (Contacte c : results) {
            resultMap.put(c.getID(), c);
        }
        return resultMap;
    }

    @Override
    public Contacte updatingContacte(int selectedID, String changeName, String changeSur, String changePhone, String changeMail) {
        Transaction transaction = session.beginTransaction();
        Contacte contact = session.get(Contacte.class, selectedID);
        if (contact != null) {
            if (!changeName.equals("*")) {
                contact.setName(changeName);
            }

            if (!changeSur.equals("*")) {
                contact.setSurnames(changeSur);
            }

            if (!changePhone.equals("*")) {
                contact.setPhone(changePhone);
            }

            if (!changeMail.equals("*")) {
                contact.setEmail(changeMail);
            }
        }
        transaction.commit();
        return Controller.super.updatingContacte(selectedID, changeName, changeSur, changePhone, changeMail);
    }

}
