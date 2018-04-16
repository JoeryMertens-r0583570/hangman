package domain;

public class Rechthoek {
	
	private int breedte;
	private int hoogte;
	private Punt linkerBovenhoek;
	
	public Rechthoek(Punt LinkerBovenhoek, int breedte, int hoogte) throws DomainException {
		setBreedte(breedte);
		setHoogte(hoogte);
		setLinkerBovenhoek(LinkerBovenhoek);
	}

	public int getBreedte() {
		return breedte;
	}

	private void setBreedte(int breedte) throws DomainException{
		if (breedte <= 0) throw new DomainException();
		else this.breedte = breedte;
	}

	public int getHoogte() {
		return hoogte;
	}

	private void setHoogte(int hoogte) throws DomainException {
		if (hoogte <= 0) throw new DomainException();
		this.hoogte = hoogte;
	}

	public Punt getLinkerBovenhoek() {
		return linkerBovenhoek;
	}

	private void setLinkerBovenhoek(Punt linkerBovenhoek) throws DomainException {
		if (linkerBovenhoek == null) throw new DomainException();
		this.linkerBovenhoek = linkerBovenhoek;
	}
	
	public boolean equals(Rechthoek object) {
		if (object == null ) return false;
		if (this.breedte == object.getBreedte() && this.hoogte == object.getHoogte()&& this.linkerBovenhoek == object.getLinkerBovenhoek()) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		return ("Rechthoek: "+linkerBovenhoek.toString()+" - breedte: "+breedte+" - hoogte: "+hoogte);
	}

}
