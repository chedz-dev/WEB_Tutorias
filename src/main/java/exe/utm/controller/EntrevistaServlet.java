package exe.utm.controller;

import exe.utm.dao.AlumnoServiceImpl;
import exe.utm.dao.ProfesorServiceImpl;
import exe.utm.service.AlumnoService;
import exe.utm.service.ProfesorService;
import exe.utm.structure.Alumno;
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

@WebServlet(name = "EntrevistaServlet", urlPatterns = {"/Entrevista"})
public class EntrevistaServlet extends HttpServlet {

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
                id = Integer.parseInt(request.getParameter("id"));
                dbop =  new AlumnoServiceImpl ();
                ProfesorService profop = new ProfesorServiceImpl ();
                Alumno alumno = dbop.getAlumno(id);
                List<Profesor> profesores = profop.getAll();
                request.setAttribute("alumno", alumno);
                request.setAttribute("profesores", profesores);
                request.setAttribute("tutor", dbop.getTutor(id));
                direccion = "/WEB-INF/AlumnoDetail.jsp";
                break;
            case "INS_RED":
                dbop = new AlumnoServiceImpl();
                Alumno alumno2 = dbop.getAlumno(Integer.parseInt(request.getParameter("id")));
                String entrevistador = request.getParameter("entrevistador");
                request.setAttribute("alumno", alumno2);
                request.setAttribute("entrevistador", entrevistador);
                direccion = "/WEB-INF/InsertEntrevista.jsp";
                break;
            case "INS":
                direccion = "/WEB-INF/Alumno?action=PROF_QUERY";
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
