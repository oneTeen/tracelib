package subcontrollers;

import entities.Loan;
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
import sessionBeans.EJBReportServiceLocal;

public class SubCReport implements ControllerInterface, Serializable {

    EJBReportServiceLocal eJBReportService = lookupEJBReportServiceLocal();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, HttpServlet servlet) {
        String url = "report.jsp";
        String action = request.getParameter("action");

        if ("display".equalsIgnoreCase(action)) {
            List<Loan> rl = eJBReportService.getOutstanding();
            request.setAttribute("report", rl);
            url = "report.jsp";
        }

        return url;
    }

    private EJBReportServiceLocal lookupEJBReportServiceLocal() {
        try {
            Context c = new InitialContext();
            return (EJBReportServiceLocal) c.lookup("java:global/traceTestJEE/traceTestJEE-ejb/EJBReportService!sessionBeans.EJBReportServiceLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
