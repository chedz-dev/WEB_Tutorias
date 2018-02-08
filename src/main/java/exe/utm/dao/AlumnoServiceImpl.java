package exe.utm.dao;

import exe.utm.service.AlumnoService;
import exe.utm.structure.Alumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

public class AlumnoServiceImpl implements AlumnoService {
    private static final Logger LOGGER = Logger.getLogger(AlumnoServiceImpl.class.getName());
    private Connection conn;
    private final DBConnection dbconn = new DBConnection ();
    
    private static final String QUERY_ALL = "SELECT * FROM alumno";
    private static final String QUERY_ALUMNO = "SELECT * FROM alumno WHERE id = ?";
    
    private static final String INSERT_ALUMNO = "INSERT INTO alumno (matricula,nombre,apellidos,foto,correo) VALUES (?,?,?,?,?)";
    
    private static final String UPDATE_ALUMNO = "UPDATE alumno SET matricula=?,nombre=?,apellidos=?,foto=?,correo=? WHERE id = ?";
    
    private static final String DELETE_ALUMNO = "DELETE FROM alumno WHERE id = ?";
    
    @Override
    public List<Alumno> getAll() {
        List<Alumno> resultList = new LinkedList ();
        Alumno alumno = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        LOGGER.info("AlumnoServiceImpl->getAll method invoke");

        try {
            conn = dbconn.connectToDB();
            ps = conn.prepareStatement(QUERY_ALL);
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
                resultList.add(alumno);
            }
            DBOperation.closePreparedStatement(ps);
        } catch (SQLException e) {
            LOGGER.severe("AlumnoServiceImpl->getAll error: " + e.getLocalizedMessage());
        } finally {
            DBOperation.closeConnection(conn, ps, rs);
        }
        return resultList;
    }

    @Override
    public Alumno getAlumno(Integer id) {
        Alumno alumno = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        LOGGER.info("AlumnoServiceImpl->getAlumno method invoke");

        try {
            conn = dbconn.connectToDB();
            ps = conn.prepareStatement(QUERY_ALUMNO);
            ps.setInt(1, id);
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
            }
            DBOperation.closePreparedStatement(ps);
        } catch (SQLException e) {
            LOGGER.severe("AlumnoServiceImpl->getAlumno error: " + e.getLocalizedMessage());
        } finally {
            DBOperation.closeConnection(conn, ps, rs);
        }
        return alumno;
    }

    @Override
    public void insert(String matricula, String nombre, String apellidos, String foto, String correo) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        LOGGER.info("AlumnoServiceImpl->insertAlumno method invoke");
        try {
            conn = dbconn.connectToDB();
            ps = conn.prepareStatement(INSERT_ALUMNO);
            ps.setString(1, matricula);
            ps.setString(2, nombre);
            ps.setString(3, apellidos);
            ps.setString(4, matricula + nombre + ".jpg");
            ps.setString(5, correo);
  
            LOGGER.info("INSERT_ALUMNO insert: " + ps.toString());
            LOGGER.info("Executing insert: " + ps.toString());
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            LOGGER.severe("AlumnoServiceImpl->insertAlumno error: " + e.getLocalizedMessage());
        } finally {
            DBOperation.closeConnection(conn, ps, rs);
        }
    }

    @Override
    public void update(Integer id, String matricula, String nombre, String apellidos, String foto, String correo) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        LOGGER.info("AlumnoServiceImpl->updateAlumno method invoke");
        try {
            conn = dbconn.connectToDB();
            ps = conn.prepareStatement(UPDATE_ALUMNO);
            ps.setString(1, matricula);
            ps.setString(2, nombre);
            ps.setString(3, apellidos);
            ps.setString(4, foto);
            ps.setString(5, correo);
            ps.setInt(6, id);
  
            LOGGER.info("UPDATE_ALUMNO update: " + ps.toString());
            LOGGER.info("Executing update: " + ps.toString());
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            LOGGER.severe("AlumnoServiceImpl->updateAlumno error: " + e.getLocalizedMessage());
        } finally {
            DBOperation.closeConnection(conn, ps, rs);
        }
    }

    @Override
    public void delete(Integer id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        LOGGER.info("AlumnoServiceImpl->deleteAlumno method invoke");
        try {
            conn = dbconn.connectToDB();
            ps = conn.prepareStatement(DELETE_ALUMNO);
            ps.setInt(1, id);
  
            LOGGER.info("DELETE_ALUMNO update: " + ps.toString());
            LOGGER.info("Executing delete: " + ps.toString());
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            LOGGER.severe("AlumnoServiceImpl->deleteAlumno error: " + e.getLocalizedMessage());
        } finally {
            DBOperation.closeConnection(conn, ps, rs);
        }
    }
    
}
