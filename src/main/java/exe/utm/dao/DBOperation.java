package exe.utm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class DBOperation {
    private static final Logger LOGGER = Logger.getLogger(DBOperation.class.getName());
    private Connection conn;
    private final DBConnection dbconn = new DBConnection ();
    
    
    private static final String QUERY_PROFESOR = "SELECT * FROM profesor WHERE usuario = ?";
    
    public List<String> getUser (String user) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        LOGGER.info("DBOperation->getUser method invoke");
        List<String> resultArray = new ArrayList ();
        try {
            conn = dbconn.connectToDB();
            ps = conn.prepareStatement(QUERY_PROFESOR);
            ps.setString(1, user);
            LOGGER.info("Executing query: " + ps.toString());
            rs = ps.executeQuery();

            while (rs.next()) {
                
                resultArray.add(String.valueOf(rs.getInt("id")));
                resultArray.add(rs.getString("nombre"));
                resultArray.add(rs.getString("usuario"));
                resultArray.add(rs.getString("correo"));
                resultArray.add(rs.getString("instituto"));
            }
            closePreparedStatement(ps);
        } catch (SQLException e) {
            LOGGER.severe("DBOperation->getUser error: " + e.getLocalizedMessage());
        } finally {
            closeConnection(conn, ps, rs);
        }
        return resultArray;
    }
    
    protected static void closeResultSet(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            LOGGER.severe("DBOperation close connection error: " + e.getLocalizedMessage());
        }
    }

    protected static void closePreparedStatement(PreparedStatement ps) {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            LOGGER.severe("DBOperation close connection error: " + e.getLocalizedMessage());
        }
    }

    protected static void closeStatementAndResultSet(PreparedStatement ps, ResultSet rs) {
        closePreparedStatement(ps);
        closeResultSet(rs);
    }

    protected static void closeConnection(Connection conn, PreparedStatement ps, ResultSet rs) {
        closeStatementAndResultSet(ps, rs);
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
            LOGGER.info("CONNECTION CLOSED SUCCESSFULLY DONE!");
        } catch (SQLException e) {
            LOGGER.severe("DBOperation close connection: " + e.getLocalizedMessage());
        }
    }
}
