
package sessionBeans;

import entities.Pensioner;
import entities.Student;
import entities.Suscriber;
import java.util.*;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class EJBSubscriber implements EJBSuscriberLocal{

    @PersistenceContext(unitName = "traceTestJEE-ejbPU")
    private EntityManager em;

    public EJBSubscriber() {}

    @Override
    public void generateTestData() {
        
        List<Suscriber> sl = new ArrayList();
        
        sl.add(new Pensioner("Bill"));
        sl.add(new Pensioner("Elsie"));
        sl.add(new Pensioner("Mile"));
        sl.add(new Pensioner("Pam"));
        sl.add(new Student("Zach", "De Montfort University"));
        sl.add(new Student("Amelia", "Christchurch College"));
        sl.add(new Student("Maria", "Drexel University"));
        sl.add(new Student("Nick", "Delaware University"));
        
        sl.stream().forEach((s) -> {
            em.persist(s);
        });
        
    }
    
    @Override
    public List<Suscriber> getAll() {
        String qry = "select s from Suscriber s";
        Query qr = em.createQuery(qry);
        return qr.getResultList();
    }
}
