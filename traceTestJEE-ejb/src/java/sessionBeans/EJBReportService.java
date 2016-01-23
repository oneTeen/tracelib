package sessionBeans;

import java.util.*;

import entities.Loan;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class EJBReportService implements EJBReportServiceLocal {

    @PersistenceContext(unitName = "traceTestJEE-ejbPU")
    private EntityManager em;

    public EJBReportService() {
    }

    @Override
    public List<Loan> getOutstanding() {
        String qry = "select l from Loan l where l.returnDate < :today ";
        Query qr = em.createQuery(qry);
        qr.setParameter("today", new Date());
        return qr.getResultList();
    }
}
