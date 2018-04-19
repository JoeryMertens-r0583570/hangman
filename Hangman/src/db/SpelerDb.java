package db;

import domain.Speler;

import java.util.List;

/**
 * @author Jaro Deklerck
 */
public interface SpelerDb {
    Speler get(String naam);
    List<Speler> getAll();
    void add(Speler s);
    void update(Speler s);
    void delete(int id);
}
