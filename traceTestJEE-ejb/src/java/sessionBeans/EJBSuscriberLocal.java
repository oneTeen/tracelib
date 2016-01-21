
package sessionBeans;

import entities.Suscriber;
import java.util.List;
import javax.ejb.Local;

@Local
public interface EJBSuscriberLocal {
    public void generateTestData();
    public List<Suscriber> getAll();
}
