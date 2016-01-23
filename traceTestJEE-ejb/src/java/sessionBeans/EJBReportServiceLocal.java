
package sessionBeans;

import entities.Loan;
import java.util.List;
import javax.ejb.Local;

@Local
public interface EJBReportServiceLocal {
    public List<Loan> getOutstanding();
}
