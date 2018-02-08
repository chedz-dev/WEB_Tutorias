package exe.utm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * Clase que se encarga de crear la conexión con la base de datos.
 */
public class DBConnection {
	private static final Logger LOGGER = Logger.getLogger(DBConnection.class.getName());
	private Connection conn;
	public Connection connectToDB(){
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                System.out.println("Error al registrar el driver de MySQL: " + ex);
            }
            try {
                this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tutorias","root","");
                this.conn.setAutoCommit(false);
            } catch (SQLException e) {
                LOGGER.severe("DBConnection Error: Oops Error when connecting to the DB "+e.getLocalizedMessage());
            } finally {
                if (this.conn != null){
                    LOGGER.info("SUCCESSFUL CONNECTION TO DATABASE...");
                }
            }
            return conn;
	}
	
	public void endConnection(){
            try {
                if ( this.conn != null && !this.conn.isClosed() ){
                    this.conn.close();
                    LOGGER.info("CONNECTION CLOSED SUCCESSFULLY DONE!");
                }
            } catch (SQLException e) {
                LOGGER.severe("Error when trying to close the connection "+e.getLocalizedMessage());
            }
	}
	
	/*
	 * Getters y Setters
	 */
	public Connection getConn() {
            return conn;
	}
}
