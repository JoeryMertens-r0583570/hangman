package domain;

public abstract class Vorm implements Drawable {
    public abstract Omhullende getOmhullende();
    public abstract boolean equals(Vorm vorm);
    public abstract String toString();
}
