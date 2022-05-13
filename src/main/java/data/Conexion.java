package data;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.*;

public class Conexion {
    
    
    private static final String JDBC_URL = "jdbc:mysql://localhost/test?useSSL=false&serverTimezone=UTC";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "jere56123";
    
    
    public static DataSource getDataSource(){
        
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(JDBC_URL);
        ds.setUsername(JDBC_USER);
        ds.setPassword(JDBC_PASS);
        
        ds.setInitialSize(5);
        return ds;
        
    }
    
    public static Connection getConnection() throws SQLException{
        
       return getDataSource().getConnection();
       
      
    }
    
    public static void close(ResultSet rs) {
        
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            
        }
    }
    
   public static void close(PreparedStatement stmt){
        try {
            stmt.close();
                    } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
   }
   
   public static void close(Connection conn){
        try {
            conn.close();
        } catch (SQLException ex) {
           ex.printStackTrace(System.out);
        }
   }
}
