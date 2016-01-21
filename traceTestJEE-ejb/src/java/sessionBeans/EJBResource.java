package sessionBeans;

import entities.Resource;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class EJBResource implements EJBResourceLocal {

    @PersistenceContext(unitName = "traceTestJEE-ejbPU")
    private EntityManager em;

    public EJBResource() {}

    @Override
    public void generateTestData() {

        List<Resource> rl = new ArrayList();

        rl.add(new Resource("Book", "Lord of the Rings", "J.R.Tolkien"));
        rl.add(new Resource("Book", "2001 Space Odessey", "Arthur C Clarke"));
        rl.add(new Resource("Book", "How to win at bingo", "Two fat ladies"));
        rl.add(new Resource("Book", "The Cold. Don't let it kill you.", "J.R.Hartley"));
        rl.add(new Resource("Game", "Halo", "X-Box"));
        rl.add(new Resource("Game", "Midtown madness", "PS2"));

        rl.stream().forEach((r) -> {
            em.persist(r);
        });

    }

    @Override
    public List<Resource> getAll() {
        String qry = "select r from Resource r";
        Query qr = em.createQuery(qry);
        return qr.getResultList();
    }
}
