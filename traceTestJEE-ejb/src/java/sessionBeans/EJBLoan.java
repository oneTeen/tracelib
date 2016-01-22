package sessionBeans;

import entities.Loan;
import entities.Resource;
import entities.Suscriber;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class EJBLoan implements EJBLoanLocal {

    @PersistenceContext(unitName = "traceTestJEE-ejbPU")
    private EntityManager em;

    public EJBLoan() {}
    
    @Override
    public void genertateTestData() {
        
        List<Loan> ll = new ArrayList();
        
        ll.add(new Loan(em.find(Suscriber.class, 1l),em.find(Resource.class, 2l)));
        ll.add(new Loan(em.find(Suscriber.class, 2l),em.find(Resource.class, 4l)));
        ll.add(new Loan(em.find(Suscriber.class, 3l),em.find(Resource.class, 6l)));
        
        
        ll.stream().forEach((l) -> {
            em.persist(l);
        });
        
    }
    
    @Override
    public List<Loan> getAll() {
        String qry = "select l from Loan l";
        Query qr = em.createQuery(qry);
        return qr.getResultList();
    }


}
