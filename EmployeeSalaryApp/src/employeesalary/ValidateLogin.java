/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package payrollsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ValidateLogin {
    
    String query;
    
    public boolean checkCredentials(String table, String username, String password){
    
        query = "SELECT * FROM " + table + " WHERE username = ? AND password_hash = ?";
        
            try (Connection con = DbManager.getConnection();
                 PreparedStatement ps = con.prepareStatement(query)){
                //ID parameter
                ps.setString(1, username); 
                //Username parameter
                ps.setString(2, password);

                //Execute query
                ResultSet rs = ps.executeQuery();

                //Check if ID and username match
                return rs.next();

            } catch (SQLException e) {
                //Handling database error
                System.out.println("Error accessing database: " + e);
                return false;
            } 
        
    }
    
}
