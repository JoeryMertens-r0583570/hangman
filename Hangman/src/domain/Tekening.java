package domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

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
        if (naam == null || naam.equals("")) {
            throw new IllegalArgumentException("Naam is null of leeg");
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

    public boolean equals(Object obj) {
        if (!(obj instanceof Tekening) || (this == null && obj != null) || (this != null && obj == null) || ((Tekening) obj).getAantalVormen() != getAantalVormen()) {
            return false;
        }
        if (this == null && obj == null) {
            return true;
        }
        return getLijst().containsAll(((Tekening) obj).getLijst()) && ((Tekening) obj).getLijst().containsAll(getLijst());
    }

    public String toString() {
        String s = "Tekening met naam "+getNaam()+"bestaat uit "+getAantalVormen()+" vormen:\n";
        for (Vorm v: getLijst()) {
            s += v.toString()+"\n";
        }
        return s;
    }
}
