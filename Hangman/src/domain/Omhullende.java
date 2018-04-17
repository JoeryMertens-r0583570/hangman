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

	public void setLinkerBovenhoek(Punt linksboven) {
		this.linkerbovenhoek = linksboven;
	}

	public int getBreedte() {
		return breedte;
	}

	public void setBreedte(int breedte) {
		this.breedte = breedte;
	}

	public int getHoogte() {
		return hoogte;
	}

	public void setHoogte(int hoogte) {
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
}
