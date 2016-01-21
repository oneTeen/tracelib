package subcontrollers;

import entities.Suscriber;
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
import sessionBeans.EJBSuscriberLocal;

public class SubCSuscriber implements ControllerInterface, Serializable {

    EJBSuscriberLocal eJBSubscriber = lookupEJBSubscriberLocal();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, HttpServlet servlet) {

        String url = "main.jsp";
        String action = request.getParameter("action");

        if ("display".equalsIgnoreCase(action)) {
            List<Suscriber> sl = eJBSubscriber.getAll();
            request.setAttribute("suscribers", sl);
            url = "main.jsp";
        }

        return url;
    }

    private EJBSuscriberLocal lookupEJBSubscriberLocal() {
        try {
            Context c = new InitialContext();
            return (EJBSuscriberLocal) c.lookup("java:global/traceTestJEE/traceTestJEE-ejb/EJBSubscriber!sessionBeans.EJBSuscriberLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }


    
}
