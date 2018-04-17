package domain;

public abstract class Vorm implements Drawable {
    private boolean zichtbaar = false;

    public abstract Omhullende getOmhullende();
    public abstract boolean equals(Vorm vorm);
    public abstract String toString();

    public boolean isZichtbaar() {
        return zichtbaar;
    }

    public void setZichtbaar(boolean zichtbaar) {
        this.zichtbaar = zichtbaar;
    }
}
