package domain;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Driehoek extends Vorm {

	private Punt hoekPunt1;
	private Punt hoekPunt2;
	private Punt hoekPunt3;

	public Driehoek(Punt hoekPunt1, Punt hoekPunt2, Punt hoekPunt3) {
		setHoekPunten(hoekPunt1, hoekPunt2, hoekPunt3);
	}

	public void setHoekPunten(Punt hoekPunt1, Punt hoekPunt2, Punt hoekPunt3) {
		if (hoekPunt1 == null || hoekPunt2 == null || hoekPunt3 == null)
			throw new DomainException("Hoekpunten  mogen niet NULL zijn.");
		if (hoekPunt1.equals(hoekPunt2) || hoekPunt1.equals(hoekPunt3) || hoekPunt2.equals(hoekPunt3))
			throw new DomainException("HoekPunten mogen niet samenvallen.");
		if ((hoekPunt2.getX() - hoekPunt1.getX())
				* (hoekPunt3.getY() - hoekPunt1.getY()) == (hoekPunt3.getX() - hoekPunt1.getX())
						* (hoekPunt2.getY() - hoekPunt1.getY())) {
			throw new DomainException("Hoekpunten mogen niet op een lijn liggen");
		} else {
			this.hoekPunt1 = hoekPunt1;
			this.hoekPunt2 = hoekPunt2;
			this.hoekPunt3 = hoekPunt3;
		}
	}

	public Punt getHoekPunt1() {
		return hoekPunt1;
	}

	public Punt getHoekPunt2() {
		return hoekPunt2;
	}

	public Punt getHoekPunt3() {
		return hoekPunt3;
	}

	@Override
	public Omhullende getOmhullende() {
		return new Omhullende(
				new Punt(Math.min(hoekPunt3.getX(), Math.min(hoekPunt1.getX(), hoekPunt2.getX())),
						Math.min(hoekPunt3.getY(), Math.min(hoekPunt1.getY(), hoekPunt2.getY()))),
				Math.max(hoekPunt3.getX(), Math.max(hoekPunt1.getX(), hoekPunt2.getX()))
						- Math.min(hoekPunt3.getX(), Math.min(hoekPunt1.getX(), hoekPunt2.getX())),
						Math.max(hoekPunt3.getY(), Math.max(hoekPunt1.getY(), hoekPunt2.getY()))-Math.min(hoekPunt3.getY(), Math.min(hoekPunt1.getY(), hoekPunt2.getY())));
	}

	@Override
	public boolean equals(Vorm object) {
		if (object == null) {
			return false;
		}
	    if (!(object instanceof Driehoek)) {
	        return false;
        }
		
		Punt[] listOfPointsObject = { ((Driehoek)object).getHoekPunt1(), ((Driehoek)object).getHoekPunt2(), ((Driehoek)object).getHoekPunt3() };
		Punt[] listOfPointsThis = { this.hoekPunt1, this.hoekPunt2, this.hoekPunt3 };
		int counter=0;
		for(Punt punt:listOfPointsObject) {
			for(Punt compare:listOfPointsThis) {
				if(punt.equals(compare)) {
					counter++;
				}
			}
		}
		if (counter==3) {
			return true;
		}
		return false;
	}
    @Override
    public String toString(){
	    return "hoekpunt1: ("+ this.getHoekPunt1().getX()+", "+this.getHoekPunt1().getY()+") - "+"hoekpunt2: ("+ this.getHoekPunt2().getX()+", "+this.getHoekPunt2().getY()+") - "+"hoekpunt3: ("+ this.getHoekPunt3().getX()+", "+this.getHoekPunt3().getY()+") - %n"+this.getOmhullende().toString();
    }

	@Override
	public void teken(Graphics graphics) {

		Graphics2D graphics2D = (Graphics2D) graphics;
		graphics2D.setStroke(new BasicStroke(5));
		int[] xPoints = { this.getHoekPunt1().getX(), this.getHoekPunt2().getX(),
				this.getHoekPunt3().getX() };
		int[] yPoints = { this.getHoekPunt1().getY(), this.getHoekPunt2().getY(),
				this.getHoekPunt3().getY() };
		graphics.drawPolygon(xPoints, yPoints, 3);
		
	}
}
