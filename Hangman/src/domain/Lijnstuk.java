package domain;

/**
 * @author Jaro Deklerck
 */
public class Lijnstuk extends Vorm{
    private Punt startpunt;
    private Punt eindpunt;
    public Lijnstuk(Punt startpunt, Punt eindpunt) {
        setPunten(startpunt,eindpunt);
    }

    public Punt getStartpunt() {
        return startpunt;
    }

    public void setPunten(Punt startpunt, Punt eindpunt) {
        if (startpunt.equals(eindpunt)) {
            throw new DomainException("Startpunt en eindpunt zijn gelijk.");
        }
        this.startpunt = startpunt;
        this.eindpunt = eindpunt;
    }

    public Punt getEindpunt() {
        return eindpunt;
    }

    public boolean equals(Vorm vorm) {
        if (vorm instanceof Lijnstuk) {
            if (getStartpunt().equals(((Lijnstuk) vorm).getStartpunt()) && getEindpunt().equals(((Lijnstuk) vorm).getEindpunt())) {
                return true;
            }
        }
        return false;
    }
}
