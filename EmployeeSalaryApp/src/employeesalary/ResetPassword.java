package payrollsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResetPassword {
    
    String query;

    public ResetPassword() {
    }
    
    public boolean checkIdentity(String table, String idType, String id, String username){
        
        //Query to be used to check user's identity
        query = "SELECT * FROM " + table + " WHERE " + idType + " = ? AND username = ?";
        
            //Establishing a connection with database
            try (Connection con = DbManager.getConnection();
                 //Using prepared statement to execute the query
                 PreparedStatement ps = con.prepareStatement(query)){
                //Passing ID parameter
                ps.setString(1, id); 
                //Passing username parameter
                ps.setString(2, username);

                //Initializing ResultSet to hold query execution result
                ResultSet rs = ps.executeQuery();

                //Check if ID and username match according to result
                return rs.next();

            } catch (SQLException e) {
                //Handle database error
                System.out.println("Error accessing database: " + e);
                return false;
            } 

    }
    
     public boolean updatePassword(String table, String idType, String id, String username, String password){

        //Query to update the password in the database
        query = "UPDATE " + table + " SET password_hash = ? WHERE " + idType + " = ? AND username = ?";
        
        //Establishing a connection with database
        try (Connection con = DbManager.getConnection();
            //Using prepared statement to execute the query
             PreparedStatement ps = con.prepareStatement(query)) {
      
            //Passing password parameter
            ps.setString(1, password);
            //Passing ID parameter
            ps.setString(2, id);
            //Passing username parameter
            ps.setString(3, username);

            //Checking if any rows were affected
            return ps.executeUpdate() > 0;
        
        } catch (SQLException e) {
            //Handling database error
            System.out.println("Error accessing database: " + e);
            return false;
        }
    }    
}
