package exe.utm.controller;

import exe.utm.dao.ProfesorServiceImpl;
import exe.utm.service.ProfesorService;
import exe.utm.structure.Profesor;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ProfesorServlet", urlPatterns = {"/Profesor"})
public class ProfesorServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String direccion = "";
        Integer id;
        String action = request.getParameter("action");
        String nombre = request.getParameter("nombre");
        String usuario = request.getParameter("usuario");
        String correo = request.getParameter("correo");
        String instituto = request.getParameter("instituto");
        
        HttpSession session = request.getSession();
        if(session.getAttribute("active") == null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/Login?action=logout");
                        dispatcher.forward(request, response);
        }
        
        ProfesorService dbop;
        switch(action) {
            case "QRY":
                dbop =  new ProfesorServiceImpl ();
                List<Profesor> profesores = dbop.getAll();
                request.setAttribute("profesores", profesores);
                direccion = "/WEB-INF/ProfesorHome.jsp";
                break;
            case "INS_RED":
                direccion = "/WEB-INF/InsertProfesor.jsp";
                break;
            case "INS":
                dbop =  new ProfesorServiceImpl ();
                dbop.insert(nombre, usuario, correo, instituto);
                direccion = "/Profesor?action=QRY";
                break;
            case "UPD_RED":
                id = Integer.parseInt(request.getParameter("id"));
                dbop = new ProfesorServiceImpl ();
                request.setAttribute("profesor", dbop.getProfesor(id));
                direccion = "/WEB-INF/UpdateProfesor.jsp";
                break;
            case "UPD":
                id = Integer.parseInt(request.getParameter("id"));
                dbop = new ProfesorServiceImpl ();
                dbop.update(id, nombre, usuario, correo, instituto);
                direccion = "/Profesor?action=QRY";
                break;
            case "DEL":
                id = Integer.parseInt(request.getParameter("id"));
                dbop = new ProfesorServiceImpl ();
                dbop.delete(id);
                direccion = "/Profesor?action=QRY";
                break;
            default:
                direccion = "/index.jsp";
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(direccion);
                dispatcher.forward(request, response);
        //dbop.insertProfesor(matricula, nombre, apellidos, correo);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
