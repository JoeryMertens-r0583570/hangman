package domain;

public class Rechthoek {
	
	private int breedte;
	private int hoogte;
	private Punt linkerBovenhoek;
	
	public Rechthoek(Punt LinkerBovenhoek, int breedte, int hoogte) {
		
	}

	public int getBreedte() {
		return breedte;
	}

	private void setBreedte(int breedte) {
		this.breedte = breedte;
	}

	public int getHoogte() {
		return hoogte;
	}

	private void setHoogte(int hoogte) {
		this.hoogte = hoogte;
	}

	public Punt getLinkerBovenhoek() {
		return linkerBovenhoek;
	}

	private void setLinkerBovenhoek(Punt linkerBovenhoek) {
		this.linkerBovenhoek = linkerBovenhoek;
	}
	
	public boolean equals(Rechthoek object) {
		return false;
	}
	
	public String toString() {
		return ("Rechthoek: "+linkerBovenhoek.toString()+" - breedte: "+breedte+" - hoogte: "+hoogte);
	}

}
