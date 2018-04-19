package db;

import domain.Speler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jaro Deklerck
 */
public class SpelerTabel implements SpelerDb {

    private static String tabel = "Score";
    private Connection con;

    public SpelerTabel() {
        setCon(PgConnectie.openConnectie());
    }

    public void sluit() {
        PgConnectie.sluitConnectie(getCon());
    }

    @Override
    public Speler get(String naam) {
        try {
            PreparedStatement st = getCon().prepareStatement("SELECT * FROM " + tabel + " WHERE Naam = ?");
            st.setString(1, naam);
            ResultSet rs = st.executeQuery();
            Speler speler = new Speler(naam);
            if (rs.next()) {
                speler.setScore(rs.getInt("Score"));
            }
            rs.close();
            return speler;
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        return null;
    }

    @Override
    public List<Speler> getAll() {
        try {
            PreparedStatement st = getCon().prepareStatement("SELECT * FROM " + tabel);
            ResultSet rs = st.executeQuery();
            List<Speler> list = new ArrayList<>();
            if (rs.next()) {
                Speler speler = new Speler(rs.getString("Naam"));
                speler.setId(rs.getInt("Id"));
                speler.setScore(rs.getInt("Score"));
            }
            rs.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        return null;
    }

    @Override
    public void add(Speler s) {
        try {
            PreparedStatement st = getCon().prepareStatement("SELECT * FROM " + tabel);
            ResultSet rs = st.executeQuery();
            List<Speler> list = new ArrayList<>();
            if (rs.next()) {
                Speler speler = new Speler(rs.getString("Naam"));
                speler.setId(rs.getInt("Id"));
                speler.setScore(rs.getInt("Score"));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    }

    @Override
    public void update(Speler s) {

    }

    @Override
    public void delete(int id) {

    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
}
