package domain;

/**
 * @author Jaro Deklerck
 */
public class LijnStuk extends Vorm{
    private Punt startpunt;
    private Punt eindpunt;
    public LijnStuk(Punt startpunt, Punt eindpunt) {
        setPunten(startpunt,eindpunt);
    }

    public Punt getStartpunt() {
        return startpunt;
    }

    public void setPunten(Punt startpunt, Punt eindpunt) {
        if (startpunt == null) {
            throw new DomainException("Startpunt is null");
        }
        if (eindpunt == null) {
            throw new DomainException("Eindpunt is null");
        }
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
        if (vorm instanceof LijnStuk) {
            if (getStartpunt().equals(((LijnStuk) vorm).getStartpunt()) && getEindpunt().equals(((LijnStuk) vorm).getEindpunt())) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "Lijn: startpunt: ("+getStartpunt().getX()+", "+getStartpunt().getY()+") - eindpunt: ("+getEindpunt().getX()+", "+getEindpunt().getY()+")";
    }
}
