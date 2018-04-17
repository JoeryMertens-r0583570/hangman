package domain;

public class Omhullende {
	private int hoogte;
	private int breedte;
	private Punt linkerbovenhoek;

	public Omhullende(Punt linksboven, int breedte, int hoogte) {
		setLinkerBovenhoek(linksboven);
		setBreedte(breedte);
		setHoogte(hoogte);

	}

	public Punt getLinkerBovenhoek() {
		return linkerbovenhoek;
	}

	public void setLinkerBovenhoek(Punt linksboven) throws DomainException {
		if (linksboven == null)
			throw new DomainException();
		this.linkerbovenhoek = linksboven;
	}

	public int getBreedte() {
		return breedte;
	}

	public void setBreedte(int breedte) throws DomainException {

		if (breedte < 0)
			throw new DomainException();
		this.breedte = breedte;
	}

	public int getHoogte() {
		return hoogte;
	}

	public void setHoogte(int hoogte) throws DomainException {

		if (hoogte < 0)
			throw new DomainException();
		this.hoogte = hoogte;
	}

	public int getMinimumX() {
		return linkerbovenhoek.getX();
	}

	public int getMinimumY() {
		return linkerbovenhoek.getY() - hoogte;
	}

	public int getMaximumX() {
		return linkerbovenhoek.getX() + breedte;
	}

	public int getMaximumY() {
		return linkerbovenhoek.getY();
	}

	public boolean equals(Omhullende test) {
		if (test == null)
			return false;
		if (test.getBreedte() == this.getBreedte() && test.getHoogte() == this.getHoogte()
				&& test.getLinkerBovenhoek() == this.getLinkerBovenhoek())
			return true;
		return false;

	}

	public String toString() {
		return "Omhullende: (" + this.getLinkerBovenhoek().getX() + ", " + this.getLinkerBovenhoek().getY() + " - "
				+ this.getBreedte() + " - " + this.getHoogte();
	}
}
