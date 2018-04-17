package domain;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Rechthoek extends Vorm {

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

	private void setBreedte(int breedte) throws DomainException {
		if (breedte <= 0)
			throw new DomainException();
		else
			this.breedte = breedte;
	}

	public int getHoogte() {
		return hoogte;
	}

	private void setHoogte(int hoogte) throws DomainException {
		if (hoogte <= 0)
			throw new DomainException();
		this.hoogte = hoogte;
	}

	public Punt getLinkerBovenhoek() {
		return linkerBovenhoek;
	}

	private void setLinkerBovenhoek(Punt linkerBovenhoek) throws DomainException {
		if (linkerBovenhoek == null)
			throw new DomainException();
		this.linkerBovenhoek = linkerBovenhoek;
	}

	@Override
	public boolean equals(Vorm object) {
		if (object == null || !(object instanceof Rechthoek))
			return false;
		if (this.breedte == ((Rechthoek) object).getBreedte() && this.hoogte == ((Rechthoek) object).getHoogte()
				&& this.linkerBovenhoek == ((Rechthoek) object).getLinkerBovenhoek()) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Rechthoek: " + linkerBovenhoek.toString() + " - breedte: " + breedte + " - hoogte: " + hoogte + " -\n"
				+ getOmhullende().toString();
	}

	@Override
	public Omhullende getOmhullende() {
		return new Omhullende(this.getLinkerBovenhoek(), this.getBreedte(), this.getHoogte());
	}

	@Override
	public void teken(Graphics graphics) {
		Graphics2D graphics2D = (Graphics2D) graphics;
		graphics2D.setStroke(new BasicStroke(5));
		graphics.drawRect(this.getLinkerBovenhoek().getX(), this.getLinkerBovenhoek().getY(), this.getBreedte(),
				this.getHoogte());

	}

}
