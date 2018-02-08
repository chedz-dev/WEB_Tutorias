package exe.utm.dao;

import exe.utm.service.MateriaService;
import exe.utm.structure.Alumno;
import exe.utm.structure.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

public class MateriaServiceImpl implements MateriaService {
    private static final Logger LOGGER = Logger.getLogger(MateriaServiceImpl.class.getName());
    private Connection conn;
    private final DBConnection dbconn = new DBConnection ();
    
    private static final String QUERY_ALL = "SELECT * FROM materia";
    private static final String QUERY_MATERIA = "SELECT * FROM materia WHERE id = ?";
    
    private static final String INSERT_MATERIA = "INSERT INTO materia (nombre) VALUES (?)";
    
    private static final String UPDATE_MATERIA = "UPDATE materia SET nombre=? WHERE id = ?";
    
    private static final String DELETE_MATERIA = "DELETE FROM materia WHERE id = ?";
    
    @Override
    public List<Materia> getAll() {
        List<Materia> resultList = new LinkedList ();
        Materia materia = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        LOGGER.info("MateriaServiceImpl->getAll method invoke");

        try {
            conn = dbconn.connectToDB();
            ps = conn.prepareStatement(QUERY_ALL);
            LOGGER.info("Executing query: " + ps.toString());
            rs = ps.executeQuery();

            while (rs.next()) {
                materia = new Materia ();
                materia.setId(rs.getInt("id"));
                materia.setNombre(rs.getString("nombre"));

                resultList.add(materia);
            }
            DBOperation.closePreparedStatement(ps);
        } catch (SQLException e) {
            LOGGER.severe("MateriaServiceImpl->getAll error: " + e.getLocalizedMessage());
        } finally {
            DBOperation.closeConnection(conn, ps, rs);
        }
        return resultList;
    }

    @Override
    public Materia getMateria(Integer id) {
        Materia materia = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        LOGGER.info("MateriaServiceImpl->getMateria method invoke");

        try {
            conn = dbconn.connectToDB();
            ps = conn.prepareStatement(QUERY_MATERIA);
            ps.setInt(1, id);
            LOGGER.info("Executing query: " + ps.toString());
            rs = ps.executeQuery();

            while (rs.next()) {
                materia = new Materia ();
                materia.setId(rs.getInt("id"));
                materia.setNombre(rs.getString("nombre"));
            }
            DBOperation.closePreparedStatement(ps);
        } catch (SQLException e) {
            LOGGER.severe("MateriaServiceImpl->getMateria error: " + e.getLocalizedMessage());
        } finally {
            DBOperation.closeConnection(conn, ps, rs);
        }
        return materia;
    }

    @Override
    public void insert(String nombre) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        LOGGER.info("MateriaServiceImpl->insertMateria method invoke");
        try {
            conn = dbconn.connectToDB();
            ps = conn.prepareStatement(INSERT_MATERIA);
            ps.setString(1, nombre);

  
            LOGGER.info("INSERT_MATERIA insert: " + ps.toString());
            LOGGER.info("Executing insert: " + ps.toString());
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            LOGGER.severe("MateriaServiceImpl->insertMateria error: " + e.getLocalizedMessage());
        } finally {
            DBOperation.closeConnection(conn, ps, rs);
        }
    }

    @Override
    public void update(Integer id, String nombre) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        LOGGER.info("MateriaServiceImpl->updateAlumno method invoke");
        try {
            conn = dbconn.connectToDB();
            ps = conn.prepareStatement(UPDATE_MATERIA);
            ps.setString(1, nombre);
            ps.setInt(2, id);
  
            LOGGER.info("UPDATE_MATERIA update: " + ps.toString());
            LOGGER.info("Executing update: " + ps.toString());
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            LOGGER.severe("MateriaServiceImpl->updateMateria error: " + e.getLocalizedMessage());
        } finally {
            DBOperation.closeConnection(conn, ps, rs);
        }
    }

    @Override
    public void delete(Integer id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        LOGGER.info("MateriaServiceImpl->deleteAlumno method invoke");
        try {
            conn = dbconn.connectToDB();
            ps = conn.prepareStatement(DELETE_MATERIA);
            ps.setInt(1, id);
  
            LOGGER.info("DELETE_MATERIA update: " + ps.toString());
            LOGGER.info("Executing delete: " + ps.toString());
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            LOGGER.severe("MateriaServiceImpl->deleteAlumno error: " + e.getLocalizedMessage());
        } finally {
            DBOperation.closeConnection(conn, ps, rs);
        }
    }
    
}
