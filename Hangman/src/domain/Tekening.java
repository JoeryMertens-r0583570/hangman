package domain;

import java.util.ArrayList;

/**
 * @author Jaro Deklerck
 */
public class Tekening {
    private final static int MIN_X = 0;
    private final static int MIN_Y = 0;
    private final static int MAX_X = 399;
    private final static int MAX_Y = 399;
    private String naam;
    private ArrayList<Vorm> lijst = new ArrayList<>();

    public Tekening(String naam) {
        setNaam(naam);
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        if (naam.equals("") || naam == null) {
            throw new DomainException("Naam is null of leeg");
        }
        this.naam = naam;
    }

    public void voegToe(Vorm vorm) {
        if (vorm == null) {
            throw new DomainException("Vorm is null");
        }
        getLijst().add(vorm);
    }

    public void verwijder(Vorm vorm) {
        if (vorm == null) {
            throw new DomainException("Vorm is null");
        }
        if (bevat(vorm)) {
            getLijst().remove(vorm);
        }
        else {
            throw new DomainException("Vorm niet in tekening");
        }
    }

    public ArrayList<Vorm> getLijst() {
        return lijst;
    }

    public Vorm getVorm(int i) {
        if (i >= getAantalVormen() && i < 0) {
            throw new DomainException("Foute index");
        }
        return getLijst().get(i);
    }

    public int getAantalVormen() {
        return getLijst().size();
    }

    public boolean bevat(Vorm vorm) {
        for (Vorm v: getLijst()) {
            if (v.equals(vorm)) {
                return true;
            }
        }
        return false;
    }
}
