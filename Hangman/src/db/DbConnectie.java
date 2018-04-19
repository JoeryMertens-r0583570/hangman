package db;

import java.sql.*;
import java.util.Properties;

/**
 * @author Jaro Deklerck
 */
public class DbConnectie {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:postgresql://databanken.ucll.be:61718,databanken.ucll.be:61718/projektwerk";
        Properties props = new Properties();
        props.setProperty("user", "local_r0666962");
        props.setProperty("password", ":yFzAY15O$G4a9-");
        props.setProperty("ssl", "true");
        try {
            Connection con = DriverManager.getConnection(url, props);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database succesfully");
    }
}
