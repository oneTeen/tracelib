
package sessionBeans;

import entities.Loan;
import java.util.List;
import javax.ejb.Local;

@Local
public interface EJBLoanLocal {
        public void genertateTestData();
        public List<Loan> getAll();
}
