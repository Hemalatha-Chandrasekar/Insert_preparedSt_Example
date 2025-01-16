package Service;

public class SQLQueries {
    public final static String GetEmployees = "SELECT * FROM employees where employeeNumber=?";
    public final static String GetEmployeesByID = "SELECT * FROM employees where salary=?";
}
