package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * @author Jaro Deklerck
 */
public class PgConnectie {
    public static Connection openConnectie() {
        try {
            Class.forName("com.sql.jdbc.Driver").newInstance();
            System.out.println("Good to Go!");
        } catch (Exception E) {
            System.out.println("JDBC Driver error");
        }
        String url = "jdbc:postgresql://databanken.ucll.be:61718,databanken.ucll.be:61718/projektwerk";
        Properties props = new Properties();

        try {
            props.setProperty("user", "local_r0666962");
            props.setProperty("password", ":yFzAY15O$G4a9-");
            props.setProperty("ssl", "true");
            Connection con = DriverManager.getConnection(url, props);
            return con;
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        return null;
    }

    public static void sluitConnectie(Connection c) {
        try {
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Closed database succesfully");
    }
}
