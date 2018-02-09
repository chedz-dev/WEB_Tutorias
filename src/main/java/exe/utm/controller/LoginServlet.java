package exe.utm.controller;

import exe.utm.security.Authentication;
import java.io.IOException;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet", urlPatterns = "/Login")
public class LoginServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(getClass().getName());

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        
        String user = req.getParameter("user");
        LOGGER.info("Intento de loggeo usuario : " + user);
        try {
            switch(req.getParameter("action")) {
                case "login":
                    Authentication auth = new Authentication ();
                    String userRole = auth.authenticateUser(user);
                    if (!userRole.equals("")) {
                        String direccion;
                        HttpSession session = req.getSession();
                        session.setAttribute("role", userRole);
                        session.setAttribute("name", user);
                        session.setAttribute("active", true);
                        if(userRole.equals("profesor"))
                            direccion= "PROF_QRY";
                        else
                            direccion = "QRY";
                        RequestDispatcher dispatcher = req.getRequestDispatcher("/Alumno?action="+direccion);
                        dispatcher.forward(req, resp);
                    } else {
                        req.setAttribute("logerror", "Credenciales incorrectas, vuelve a intentarlo");
                        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
                        dispatcher.forward(req, resp);
                    }
                    break;
                case "logout":
                    HttpSession session = req.getSession();
                    session.invalidate();
                    RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
                        dispatcher.forward(req, resp);
                    break;
            }
        } catch (IOException | ServletException ex) {
            req.setAttribute("message", ex.getLocalizedMessage());
            req.getRequestDispatcher("/WEB-INF/ErrorResponse.jsp").include(req, resp);
            LOGGER.severe("IndexServlet error: " + ex.getLocalizedMessage());
        }
    }

@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
