package exe.utm.controller;

import exe.utm.dao.AlumnoServiceImpl;
import exe.utm.service.AlumnoService;
import exe.utm.structure.Alumno;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AlumnoServlet", urlPatterns = {"/Alumno"})
public class AlumnoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String direccion = "";
        Integer id;
        String action = request.getParameter("action");
        String matricula = request.getParameter("matricula");
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String foto = request.getParameter("foto");
        String correo = request.getParameter("correo");
        
        HttpSession session = request.getSession();
        if(session.getAttribute("active") == null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/Login?action=logout");
                        dispatcher.forward(request, response);
        }
        
        AlumnoService dbop;
        switch(action) {
            case "QRY":
                dbop =  new AlumnoServiceImpl ();
                List<Alumno> alumnos = dbop.getAll();
                request.setAttribute("alumnos", alumnos);
                direccion = "/WEB-INF/AlumnoHome.jsp";
                break;
            case "INS_RED":
                direccion = "/WEB-INF/InsertAlumno.jsp";
                break;
            case "INS":
                dbop =  new AlumnoServiceImpl ();
                dbop.insert(matricula, nombre, apellidos, foto, correo);
                direccion = "/Alumno?action=QRY";
                break;
            case "UPD_RED":
                id = Integer.parseInt(request.getParameter("id"));
                dbop = new AlumnoServiceImpl ();
                request.setAttribute("alumno", dbop.getAlumno(id));
                direccion = "/WEB-INF/UpdateAlumno.jsp";
                break;
            case "UPD":
                id = Integer.parseInt(request.getParameter("id"));
                dbop = new AlumnoServiceImpl ();
                dbop.update(id, matricula, nombre, apellidos, foto, correo);
                direccion = "/Alumno?action=QRY";
                break;
            case "DEL":
                id = Integer.parseInt(request.getParameter("id"));
                dbop = new AlumnoServiceImpl ();
                dbop.delete(id);
                direccion = "/Alumno?action=QRY";
                break;
            default:
                direccion = "/index.jsp";
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(direccion);
                dispatcher.forward(request, response);
        //dbop.insertAlumno(matricula, nombre, apellidos, correo);
        
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
