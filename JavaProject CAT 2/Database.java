import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Database {
   
    private static final Logger logger = Logger.getLogger(Database.class.getName());
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver"; //driver class
    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/cat2"; //connection url link 
    private static final String DB_USER = "root";  //username
    private static final String DB_PASSWORD = ""; //the password is always set to null
   
    static Connection con = null; 
   
    public static Connection Database() {
       
        try {
            Class.forName(DB_DRIVER);
            //Open a connection
            Connection con = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            System.out.println("Connected to the Database" );
            return con;
           
        } catch (ClassNotFoundException jdbcEx) {
            logger.log(Level.SEVERE, jdbcEx.getMessage());
            System.out.println("Failed to load connector jdbc");
        } catch (SQLException sqlEx) {
            logger.log(Level.SEVERE, sqlEx.getMessage());
            System.out.println("Failed to connect" );
        }
        return con;
    }
   

}
