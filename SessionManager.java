package payrollsystem;

public class SessionManager {
    private static SessionManager instance = null;
    private String user, fName, lName, role;
    private int id, weekNumber, totalHours;
    private double salary;

    private SessionManager() {}

    public static synchronized SessionManager getInstance() {
        if (instance == null) instance = new SessionManager();
        
        return instance;
    }

    public SessionManager(int id, int weekNumber, int totalHours, double salary) {
        this.id = id;
        this.weekNumber = weekNumber;
        this.totalHours = totalHours;
        this.salary = salary;
    }
    

    public void setUser(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }
    
    public void setID(int id){
        this.id = id;
    }
    
    public int getID(){
        return id;
    }
    
    public void setName(String fName, String lName){
        this.fName = fName;
        this.lName = lName;
    }
    
    public String getName(){
        return fName + " " + lName;
    }
    
    public void setRole(String role){
        this.role = role;
    }
    
    public String getRole(){
        return role;
    }

    public void setTotalHours(int totalHours) {
        this.totalHours = totalHours;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getTotalHours() {
        return totalHours;
    }

    public double getSalary() {
        return salary;
    }

    public int getWeekNumber() {
        return weekNumber;
    }

    public void setWeekNumber(int weekNumber) {
        this.weekNumber = weekNumber;
    }
    
    public void clearSession() {
        instance = null; // Clear session on logout
    }
}
