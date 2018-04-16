package domain;

/**
 * @author Jaro Deklerck
 */
public class Cirkel extends Punt {
    private int radius;
    private Punt middelpunt;

    public Cirkel(Punt punt, int radius) {
        setMiddelpunt(punt);
        setRadius(radius);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius te klein");
        }
        this.radius = radius;
    }

    public Punt getMiddelpunt() {
        return middelpunt;
    }

    public void setMiddelpunt(Punt middelpunt) {
        if (middelpunt == null) {
            throw new IllegalArgumentException("Middelpunt is null");
        }
        this.middelpunt = middelpunt;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Cirkel) {
            if (((Cirkel) obj).getMiddelpunt() == this.getMiddelpunt() && ((Cirkel) obj).getRadius() == this.getRadius()) {
                return true;
            }
        }
        return false;
    }
    public String toString() {
        String s = "Cirkel: middelPunt: ("+getMiddelpunt().getX()+", "+getMiddelpunt().getY()+") - straal: "+getRadius();
        return s;
    }
}
