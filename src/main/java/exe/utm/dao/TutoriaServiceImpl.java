/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exe.utm.dao;

import exe.utm.service.TutoriaService;
import exe.utm.structure.Alumno;
import exe.utm.structure.Entrevista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author Exequetor
 */
public class TutoriaServiceImpl implements TutoriaService {
    private static final Logger LOGGER = Logger.getLogger(TutoriaServiceImpl.class.getName());
    private Connection conn;
    private final DBConnection dbconn = new DBConnection ();
    
    private static final String QUERY_TUTORADOS_BY_PROFESOR = "SELECT * FROM alumno WHERE tutor_id = ?";
    
    @Override
    public List<Entrevista> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Entrevista getEntrevista(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Entrevista> getEntrevistaByAlumno(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Alumno> getTutoradosByProfesor(Integer profesorId) {
        List<Alumno> resultList = new LinkedList ();
        Alumno alumno = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        LOGGER.info("TutoriaServiceImpl->getTutoradosByProfesor method invoke");

        try {
            conn = dbconn.connectToDB();
            ps = conn.prepareStatement(QUERY_TUTORADOS_BY_PROFESOR);
            ps.setInt(1, profesorId);
            LOGGER.info("Executing query: " + ps.toString());
            rs = ps.executeQuery();

            while (rs.next()) {
                alumno = new Alumno ();
                alumno.setId(rs.getInt("id"));
                alumno.setMatricula(rs.getString("matricula"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setApellidos(rs.getString("apellidos"));
                alumno.setFoto(rs.getString("foto"));
                alumno.setCorreo(rs.getString("correo"));
                alumno.setTutorId(rs.getInt("tutor_id"));
                resultList.add(alumno);
            }
            DBOperation.closePreparedStatement(ps);
        } catch (SQLException e) {
            LOGGER.severe("TutoriaServiceImpl->getTutoradosByProfesor error: " + e.getLocalizedMessage());
        } finally {
            DBOperation.closeConnection(conn, ps, rs);
        }
        return resultList;
    }

    @Override
    public void insert(String nombre, String usuario, String correo, String instituto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
