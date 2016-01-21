package subcontrollers;

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
import sessionBeans.EJBResourceLocal;

public class SubCResource implements ControllerInterface, Serializable {

    EJBResourceLocal eJBResource = lookupEJBResourceLocal();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, HttpServlet servlet) {

        String url = "resources.jsp";
        String action = request.getParameter("action");

        if ("display".equalsIgnoreCase(action)) {
            List<Resource> rl = eJBResource.getAll();
            request.setAttribute("resources", rl);
            url = "resources.jsp";
        }

        return url;
    }

    private EJBResourceLocal lookupEJBResourceLocal() {
        try {
            Context c = new InitialContext();
            return (EJBResourceLocal) c.lookup("java:global/traceTestJEE/traceTestJEE-ejb/EJBResource!sessionBeans.EJBResourceLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    

}
