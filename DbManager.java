package payrollsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbManager {
    
    //Variables that will allow the connection to the database
    private static final String DB_URL = "jdbc:mysql://database-1.cvu4aceii2zn.eu-west-1.rds.amazonaws.com:3306/Payroll";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "payrollpassword";

    public DbManager() {  
    }
    
    public static Connection getConnection() throws SQLException {
        //Establish connection to the database
        return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    }
}
