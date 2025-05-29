import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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

}
