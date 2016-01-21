
package subcontrollers;

import entities.Loan;
import entities.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sessionBeans.EJBLoanLocal;

public class SubCLoan  implements ControllerInterface, Serializable {

    EJBLoanLocal eJBLoan = lookupEJBLoanLocal();
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, HttpServlet servlet) {

        String url = "loans.jsp";
        String action = request.getParameter("action");

        if ("display".equalsIgnoreCase(action)) {
            List<Loan> ll = eJBLoan.getAll();
            request.setAttribute("loans", ll);
            url = "loans.jsp";
        }

        return url;
    }

    private EJBLoanLocal lookupEJBLoanLocal() {
        try {
            Context c = new InitialContext();
            return (EJBLoanLocal) c.lookup("java:global/traceTestJEE/traceTestJEE-ejb/EJBLoan!sessionBeans.EJBLoanLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
