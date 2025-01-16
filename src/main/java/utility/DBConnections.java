package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnections {

    public static Connection getDBConnection() throws ClassNotFoundException, SQLException {
        // step 1:
       Class.forName("com.mysql.cj.jdbc.Driver");//optioal
        String dburl = "jdbc:mysql://localhost:3306/classicmodels";
        String user = "root";
        String password = "welcome#1";
        // step 2:
        Connection connection= DriverManager.getConnection(dburl, user, password);
        return connection;
    }

}
