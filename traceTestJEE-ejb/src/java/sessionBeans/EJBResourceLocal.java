
package sessionBeans;

import entities.Resource;
import java.util.List;
import javax.ejb.Local;

@Local
public interface EJBResourceLocal {
    public void generateTestData();
    public List<Resource> getAll();
}
