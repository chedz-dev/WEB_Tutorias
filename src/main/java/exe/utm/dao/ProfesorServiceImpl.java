package exe.utm.dao;

import exe.utm.service.ProfesorService;
import exe.utm.structure.Profesor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

public class ProfesorServiceImpl implements ProfesorService {
    private static final Logger LOGGER = Logger.getLogger(ProfesorServiceImpl.class.getName());
    private Connection conn;
    private final DBConnection dbconn = new DBConnection ();
    
    private static final String QUERY_ALL = "SELECT * FROM profesor";
    private static final String QUERY_PROFESOR = "SELECT * FROM profesor WHERE id = ?";
    
    private static final String INSERT_PROFESOR = "INSERT INTO profesor (nombre,usuario,correo,instituto) VALUES (?,?,?,?)";
    
    private static final String UPDATE_PROFESOR = "UPDATE profesor SET nombre=?,usuario=?,correo=?,instituto=? WHERE id = ?";
    
    private static final String DELETE_PROFESOR = "DELETE FROM profesor WHERE id = ?";
    
    @Override
    public List<Profesor> getAll() {
        List<Profesor> resultList = new LinkedList ();
        Profesor profesor = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        LOGGER.info("ProfesorServiceImpl->getAll method invoke");

        try {
            conn = dbconn.connectToDB();
            ps = conn.prepareStatement(QUERY_ALL);
            LOGGER.info("Executing query: " + ps.toString());
            rs = ps.executeQuery();

            while (rs.next()) {
                profesor = new Profesor ();
                profesor.setId(rs.getInt("id"));
                profesor.setNombre(rs.getString("nombre"));
                profesor.setUsuario(rs.getString("usuario"));
                profesor.setCorreo(rs.getString("correo"));
                profesor.setInstituto(rs.getString("instituto"));
                resultList.add(profesor);
            }
            DBOperation.closePreparedStatement(ps);
        } catch (SQLException e) {
            LOGGER.severe("ProfesorServiceImpl->getAll error: " + e.getLocalizedMessage());
        } finally {
            DBOperation.closeConnection(conn, ps, rs);
        }
        return resultList;
    }

    @Override
    public Profesor getProfesor(Integer id) {
        Profesor profesor = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        LOGGER.info("ProfesorServiceImpl->getProfesor method invoke");

        try {
            conn = dbconn.connectToDB();
            ps = conn.prepareStatement(QUERY_PROFESOR);
            ps.setInt(1, id);
            LOGGER.info("Executing query: " + ps.toString());
            rs = ps.executeQuery();

            while (rs.next()) {
                profesor = new Profesor ();
                profesor.setId(rs.getInt("id"));
                profesor.setNombre(rs.getString("nombre"));
                profesor.setUsuario(rs.getString("usuario"));
                profesor.setCorreo(rs.getString("correo"));
                profesor.setInstituto(rs.getString("instituto"));
            }
            DBOperation.closePreparedStatement(ps);
        } catch (SQLException e) {
            LOGGER.severe("ProfesorServiceImpl->getProfesor error: " + e.getLocalizedMessage());
        } finally {
            DBOperation.closeConnection(conn, ps, rs);
        }
        return profesor;
    }

    @Override
    public void insert(String nombre, String usuario, String correo, String instituto) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        LOGGER.info("ProfesorServiceImpl->insertProfesor method invoke");
        try {
            conn = dbconn.connectToDB();
            ps = conn.prepareStatement(INSERT_PROFESOR);
            ps.setString(1, nombre);
            ps.setString(2, usuario);
            ps.setString(3, correo);
            ps.setString(4, instituto);
  
            LOGGER.info("INSERT_PROFESOR insert: " + ps.toString());
            LOGGER.info("Executing insert: " + ps.toString());
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            LOGGER.severe("ProfesorServiceImpl->insertProfesor error: " + e.getLocalizedMessage());
        } finally {
            DBOperation.closeConnection(conn, ps, rs);
        }
    }

    @Override
    public void update(Integer id, String nombre, String usuario, String correo, String instituto) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        LOGGER.info("ProfesorServiceImpl->updateProfesor method invoke");
        try {
            conn = dbconn.connectToDB();
            ps = conn.prepareStatement(UPDATE_PROFESOR);
            ps.setString(1, nombre);
            ps.setString(2, usuario);
            ps.setString(3, correo);
            ps.setString(4, instituto);
            ps.setInt(5, id);
  
            LOGGER.info("UPDATE_PROFESOR update: " + ps.toString());
            LOGGER.info("Executing update: " + ps.toString());
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            LOGGER.severe("ProfesorServiceImpl->updateProfesor error: " + e.getLocalizedMessage());
        } finally {
            DBOperation.closeConnection(conn, ps, rs);
        }
    }

    @Override
    public void delete(Integer id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        LOGGER.info("ProfesorServiceImpl->deleteProfesor method invoke");
        try {
            conn = dbconn.connectToDB();
            ps = conn.prepareStatement(DELETE_PROFESOR);
            ps.setInt(1, id);
  
            LOGGER.info("DELETE_PROFESOR update: " + ps.toString());
            LOGGER.info("Executing delete: " + ps.toString());
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            LOGGER.severe("ProfesorServiceImpl->deleteProfesor error: " + e.getLocalizedMessage());
        } finally {
            DBOperation.closeConnection(conn, ps, rs);
        }
    }
    
}
